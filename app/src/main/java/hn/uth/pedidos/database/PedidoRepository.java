package hn.uth.pedidos.database;

//Se une el Dao, se detallan las operaciones del dao

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PedidoRepository {

    private PedidoDao dao;
    private LiveData<List<Pedido>> dataset;

    //Se crea la base de datos
    public PedidoRepository(Application app) {
        OrdenesDatabase db = OrdenesDatabase.getDatabase(app);
        this.dao = db.pedidoDao();
        this.dataset = dao.getPedidos();
    }

    public LiveData<List<Pedido>> getDataset() { return dataset; }

    public void insert(Pedido nuevo){
        //Insertando de forma asincrona, para no afectar la interfaz de usuario
        OrdenesDatabase.databaseWriteExecutor.execute(() ->{
            dao.insert(nuevo);
        });
    }

    public void update(Pedido actualizar){
        //Actualizando de forma asincrona, para no afectar la interfaz de usuario
        OrdenesDatabase.databaseWriteExecutor.execute(() ->{
            dao.update(actualizar);
        });
    }

    public void delete(Pedido borrar){
        //Eliminando un registro de forma asincrona, para no afectar la interfaz de usuario
        OrdenesDatabase.databaseWriteExecutor.execute(() ->{
            dao.delete(borrar);
        });
    }

    public void deleteAll(){
        //Eliminando todos los registros de forma asincrona, para no afectar la interfaz de usuario
        OrdenesDatabase.databaseWriteExecutor.execute(() ->{
            dao.deleteAll();
        });
    }

}
