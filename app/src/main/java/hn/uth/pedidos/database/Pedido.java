package hn.uth.pedidos.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pedidos_table")
public class Pedido {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Integer idPedido;

    @NonNull
    @ColumnInfo(name = "autor")
    private String autor;

    @NonNull
    @ColumnInfo(name = "direccion")
    private String direccionentrega;


    @ColumnInfo(name = "estado")
    private String estado;

    @NonNull
    @ColumnInfo(name = "detalle")
    private String detalle;


    public Pedido(@NonNull String autor, @NonNull String direccionentrega, String estado, @NonNull String detalle) {
        this.autor = autor;
        this.direccionentrega = direccionentrega;
        this.estado = estado;
        this.detalle = detalle;
    }

    @NonNull
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(@NonNull Integer idPedido) {
        this.idPedido = idPedido;
    }

    @NonNull
    public String getAutor() {
        return autor;
    }

    public void setAutor(@NonNull String autor) {
        this.autor = autor;
    }

    @NonNull
    public String getDireccionentrega() {
        return direccionentrega;
    }

    public void setDireccionentrega(@NonNull String direccionentrega) {
        this.direccionentrega = direccionentrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @NonNull
    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(@NonNull String detalle) {
        this.detalle = detalle;
    }
}
