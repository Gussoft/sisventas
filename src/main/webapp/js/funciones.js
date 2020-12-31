$(document).ready(function () {

    $("tr #delete").click(function () {
        var idp = $(this).parent().find("#idp").val();

        swal({
            title: "¿Estás seguro?",
            text: "Una vez eliminado, ¡no podrás recuperar este archivo!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(idp);
                swal("¡Tu archivo ha sido eliminado!", {
                    icon: "success",
                }).then((willDelete) => {
                    if (willDelete) {
                        parent.location.href = "ProductoServlet?accion=Carrito";
                    }
                });
            } else {
                swal("¡Tu archivo  está a salvo!");
            }
        });

        //eliminar(idp);

    });

    function eliminar(idp) {
        var url = "ProductoServlet?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success: function (data, textStatus, jqXHR) {
                //alert("Eliminado");
            }
        });
    }

    $("tr #cantidad").click(function () {
        var idp = $(this).parent().find("#idpro").val();
        var cantidad = $(this).parent().find("#cantidad").val();
        var url = "ProductoServlet?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp + "&cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href = "ProductoServlet?accion=Carrito";
            }
        });
    });
    function mesage() {
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!',
            timer: 90000
        }).then((result) => {
            if (result.value) {
                eliminar(idp);
                Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                        )
            }
        })
    }
});