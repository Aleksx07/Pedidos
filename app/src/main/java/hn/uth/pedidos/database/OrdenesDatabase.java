package hn.uth.pedidos.database;

//base de datos

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Si la base de datos surgio modificaciones se cambie la version
//se agregan las entidades. ej; {Pedido.class, Cliente.class}
@Database(version = 1, exportSchema = false, entities = {Pedido.class})

public abstract class OrdenesDatabase extends RoomDatabase {
    public abstract PedidoDao pedidoDao();

    private static volatile OrdenesDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //Genenerando una instancia mediante un patron de software SINGLETON
    static OrdenesDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (OrdenesDatabase.class){

                Callback miCallback = new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);

                        databaseWriteExecutor.execute(() ->{
                            PedidoDao dao = INSTANCE.pedidoDao();
                            dao.deleteAll();

                            //Llena valores por defectos en la base de datos
                            Pedido nuevo1 = new Pedido("Roberto Hernandes", "Residencial Agua Salada", "Entregado", "Dos cajas de leche" );
                            Pedido nuevo2 = new Pedido("Susana Caballero", "Residencial Vistas Hermosa", "Entregado", "Una pizza suprema" );
                            dao.insert(nuevo1);
                            dao.insert(nuevo2);

                        });
                    }
                };
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), OrdenesDatabase.class, "ordenes_db").addCallback(miCallback).build();
                }
            }
            return INSTANCE;
        }

    }

