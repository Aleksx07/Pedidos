package hn.uth.pedidos.ui.pedidos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hn.uth.pedidos.OnItemClickListener;
import hn.uth.pedidos.database.Pedido;
import hn.uth.pedidos.databinding.PedidoItemBinding;

public class PedidosAdapter extends RecyclerView.Adapter<PedidosAdapter.viewHolder> {

    private List<Pedido> dataset;
    private OnItemClickListener<Pedido> manejadorEventoClick;

    public PedidosAdapter(List<Pedido> dataset, OnItemClickListener<Pedido> manejadorEventoClick) {
        this.dataset = dataset;
        this.manejadorEventoClick = manejadorEventoClick;
    }

    @NonNull
    @Override
    public PedidosAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PedidoItemBinding binding = PedidoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidosAdapter.viewHolder holder, int position) {
    Pedido pedidoMostrar = dataset.get(position);
    holder.binding.tvNombre.setText(pedidoMostrar.getAutor());
    holder.binding.tvDireccion.setText(pedidoMostrar.getDireccionentrega());
    holder.setOnClickListener(pedidoMostrar, manejadorEventoClick);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setItems(List<Pedido> pedidos){
        this.dataset = pedidos;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        PedidoItemBinding binding;
        public viewHolder(@NonNull PedidoItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void setOnClickListener(Pedido pedidoMostrar, OnItemClickListener<Pedido> Listener) {
            this.binding.imgSearch.setOnClickListener(v -> Listener.OnItemClick(pedidoMostrar));
        }
    }
}
