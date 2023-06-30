package hn.uth.pedidos.ui.pedidos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import hn.uth.pedidos.database.Pedido;
import hn.uth.pedidos.database.PedidoRepository;

public class PedidosViewModel extends ViewModel {

    private PedidoRepository repository;
    private final LiveData<List<Pedido>> pedidoDataset;
    public PedidosViewModel(@NonNull Application app) {
        this.repository = new PedidoRepository(app);
        this.pedidoDataset = repository.getDataset();
    }

    public PedidoRepository getRepository() {
        return repository;
    }

    public LiveData<List<Pedido>> getPedidoDataset() {
        return pedidoDataset;
    }

    public void insert(Pedido nuevo){
        repository.insert(nuevo);
    }

    public void update(Pedido actualizar){
        repository.update(actualizar);
    }

    public void detele(Pedido eliminar){
        repository.delete(eliminar);
    }

    public void deteleAll(){
        repository.deleteAll();
    }
}