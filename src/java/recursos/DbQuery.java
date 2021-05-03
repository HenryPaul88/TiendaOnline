package recursos;

public class DbQuery {

    // clientes
    private static final String InsertarCliente = "insert into clientes values(?,?,?,?,?,?,?)";
    private static final String IdCliente = "select max(cod_cliente) from clientes";
    private static final String RecuperarClientes = "select cod_cliente,nombre,apellidos,telefono,email,direccion,contrasena from clientes";
    private static final String BorrarCliente = "";
    private static final String ModificarCliente = "";
    // productos
    private static final String IdProductos = "select max(cod_pro) from Producto";
    private static final String RecuperarProductos = "select cod_pro, cod_fam, nom_pro, precio, desc_pro, cod_img, cod_des from Producto";
    private static final String RecuperarProductosPrincipal = "select cod_pro, nombre_pro, precio, cod_fam, cod_des , imagen_principal, fecha_pro, descripcion from Producto where cod_fam = 5";
    private static final String InsertarProductos = "insert into Producto values(?,?,?,?,?,?,?,?)";
    private static final String RecuperarProductosImg = "select cod_pro, nombre_pro, precio, cod_fam, cod_des , imagen_principal, fecha_pro, descripcion from Producto where cod_pro= ?";
    private static final String BorrarProductos = "";
    private static final String ModificarProductos = "";

    // familias
    private static final String IdFamilias = "select max(cod_fam) from Familias";
    private static final String RecuperarFamilias = "select cod_fam, nom_fam, desc_fam from Familias";
    private static final String InsertarFamilias = "insert into Familias values(?,?,?)";
    private static final String BorrarFamilias = "";
    private static final String ModificarFamilias = "";

    // img_principal
    private static final String IdImagenes = "select max(cod_img) from img_principal";
    private static final String RecuperarImagenes = "select cod_img, ruta, ruta_abs from img_principal";
    private static final String InsertarImagenes = "insert into img_principal values(?,?,?)";
    private static final String BorrarImagenes = "";
    private static final String ModificarImagenes = "";

    // descuento
    private static final String IdDescuento = "select max(cod_des) from Descuento";
    private static final String RecuperarDescuento = "select cod_des, descuento from Descuento";
    private static final String InsertarDescuento = "insert into Descuento values(?,?)";
    private static final String BorrarDescuento = "";
    private static final String ModificarDescuento = "";

    // FormaPago
    private static final String IdFormaPago = "select max(cod_fp) from formaPago";
    private static final String RecuperarFormaPago = "";
    private static final String InsertarFormaPago = "insert into formaPago values(?,?)";
    private static final String BorrarFormaPago = "";
    private static final String ModificarFormaPago = "";

    // GastoEnvio
    private static final String IdGastoEnvio = "select max(cod_fp) from gastoEnvio";
    private static final String RecuperarGastoEnvio = "";
    private static final String InsertarGastoEnvio = "insert into gastoEnvio values(?,?,?,?)";
    private static final String BorrarGastoEnvio = "";
    private static final String ModificarGastoEnvio = "";

    // Pedido
    private static final String IdPedido = "select max(cod_fp) from pedido";
    private static final String RecuperarPedido = "";
    private static final String InsertarPedido = "";
    private static final String BorrarPedido = "";
    private static final String ModificarPedido = "";

    // LinPedido
    private static final String IdLinPedido = "select max(cod_fp) from linPedido";
    private static final String RecuperarLinPedido = "";
    private static final String InsertarLinPedido = "";
    private static final String BorrarLinPedido = "";
    private static final String ModificarLinPedido = "";

    public static String getBorrarcliente() {
        return BorrarCliente;
    }

    public static String getModificarcliente() {
        return ModificarCliente;
    }

    public static String getInsertarcliente() {
        return InsertarCliente;
    }

    public static String getIdcliente() {
        return IdCliente;
    }

    public static String getRecuperarclientes() {
        return RecuperarClientes;
    }

    public static String getIdproductos() {
        return IdProductos;
    }

    public static String getRecuperarproductos() {
        return RecuperarProductos;
    }

    public static String getRecuperarProductosPrincipal() {
        return RecuperarProductosPrincipal;
    }

    public static String getInsertarproductos() {
        return InsertarProductos;
    }

    public static String getBorrarproductos() {
        return BorrarProductos;
    }

    public static String getModificarproductos() {
        return ModificarProductos;
    }

    public static String getIdfamilias() {
        return IdFamilias;
    }

    public static String getRecuperarfamilias() {
        return RecuperarFamilias;
    }

    public static String getInsertarfamilias() {
        return InsertarFamilias;
    }

    public static String getBorrarfamilias() {
        return BorrarFamilias;
    }

    public static String getModificarfamilias() {
        return ModificarFamilias;
    }

    public static String getIdimagenes() {
        return IdImagenes;
    }

    public static String getRecuperarimagenes() {
        return RecuperarImagenes;
    }

    public static String getInsertarimagenes() {
        return InsertarImagenes;
    }

    public static String getBorrarimagenes() {
        return BorrarImagenes;
    }

    public static String getModificarimagenes() {
        return ModificarImagenes;
    }

    public static String getIddescuento() {
        return IdDescuento;
    }

    public static String getRecuperardescuento() {
        return RecuperarDescuento;
    }

    public static String getInsertardescuento() {
        return InsertarDescuento;
    }

    public static String getBorrardescuento() {
        return BorrarDescuento;
    }

    public static String getModificardescuento() {
        return ModificarDescuento;
    }

    public static String getIdformapago() {
        return IdFormaPago;
    }

    public static String getRecuperarformapago() {
        return RecuperarFormaPago;
    }

    public static String getInsertarformapago() {
        return InsertarFormaPago;
    }

    public static String getBorrarformapago() {
        return BorrarFormaPago;
    }

    public static String getModificarformapago() {
        return ModificarFormaPago;
    }

    public static String getIdgastoenvio() {
        return IdGastoEnvio;
    }

    public static String getRecuperargastoenvio() {
        return RecuperarGastoEnvio;
    }

    public static String getInsertargastoenvio() {
        return InsertarGastoEnvio;
    }

    public static String getBorrargastoenvio() {
        return BorrarGastoEnvio;
    }

    public static String getModificargastoenvio() {
        return ModificarGastoEnvio;
    }

    public static String getIdpedido() {
        return IdPedido;
    }

    public static String getRecuperarpedido() {
        return RecuperarPedido;
    }

    public static String getInsertarpedido() {
        return InsertarPedido;
    }

    public static String getBorrarpedido() {
        return BorrarPedido;
    }

    public static String getModificarpedido() {
        return ModificarPedido;
    }

    public static String getIdlinpedido() {
        return IdLinPedido;
    }

    public static String getRecuperarlinpedido() {
        return RecuperarLinPedido;
    }

    public static String getInsertarlinpedido() {
        return InsertarLinPedido;
    }

    public static String getBorrarlinpedido() {
        return BorrarLinPedido;
    }

    public static String getModificarlinpedido() {
        return ModificarLinPedido;
    }
    
    public static String getRecuperarProductosImg() {
        return RecuperarProductosImg;
    }

}
