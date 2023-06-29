package hn.uth.pedidos.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PedidoDao {

  @Insert
  void  insert(Pedido nuevo);

  @Update
  void update(Pedido actualizar);

  @Query("DELETE FROM pedidos_table")
  void deleteAll();

  @Delete
  void delete(Pedido eliminar);

  @Query("Select * From pedidos_table order by autor")
  LiveData<List<Pedido>> getPedidos();


}
