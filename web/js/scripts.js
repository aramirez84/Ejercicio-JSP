$(function () {
    var dialog, form,
            nombre = $("#nombre"),
            username = $("#username"),
            password = $("#password"),
            allFields = $([]).add(nombre).add(username).add(password),
            tips = $(".validateTips");

    function updateTips(t) {
        tips
                .text(t)
                .addClass("ui-state-highlight");
        setTimeout(function () {
            tips.removeClass("ui-state-highlight", 1500);
        }, 500);
    }

    function checkLength(o, n, min, max) {
        if (o.val().length > max || o.val().length < min) {
            o.addClass("ui-state-error");
            updateTips("Length of " + n + " must be between " +
                    min + " and " + max + ".");
            return false;
        } else {
            return true;
        }
    }

    function checkRegexp(o, regexp, n) {
        if (!(regexp.test(o.val()))) {
            o.addClass("ui-state-error");
            updateTips(n);
            return false;
        } else {
            return true;
        }
    }

    function addUser() {
        var valid = true;
        allFields.removeClass("ui-state-error");

        valid = valid && checkLength(nombre, "nombre", 3, 16);
        valid = valid && checkLength(username, "username", 3, 16);
        valid = valid && checkLength(password, "password", 5, 16);

        valid = valid && checkRegexp(nombre, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter.");
        valid = valid && checkRegexp(username, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter.");
        valid = valid && checkRegexp(password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9");

        if (valid) {
            $.post("ServletAgregar",{
                nombre:nombre.val(),
                username:username.val(),
                password:password.val()
            },function(data){
                console.log(data);
                location.reload();
            });
            dialog.dialog("close");
        }
        else
        {
           console.log("Error");
        }
        return valid;
    }

    dialog = $("#dialog-form").dialog({
        autoOpen: false,
        height: 400,
        width: 350,
        modal: true,
        buttons: {
            "Agregar usuario": addUser,
            Cancel: function () {
                dialog.dialog("cerrar");
            }
        },
        close: function () {
            form[ 0 ].reset();
            allFields.removeClass("ui-state-error");
        }
    });

    form = dialog.find("form").on("submit", function (event) {
        event.preventDefault();
        addUser();
    });

    $("#create-user").button({
        icons: {
             primary: 'ui-icon-plusthick',
             secondary: 'ui-icon-person'
        }
        }).on("click", function () {
        dialog.dialog("open");
    });
    
    /***************************************************************************
     * Configuracion de dialog form Permisos 
     **************************************************************************/
    $(".btn-agregar-permisos").button({
         icons: {
             primary: 'ui-icon-plusthick',
             secondary: 'ui-icon-flag'
        }        
    });
    $(".btn-quitar-permisos").button({
         icons: {
             primary: 'ui-icon-minusthick'
        }        
    });
    $(".btn-editar-permisos").button({
         icons: {
             primary: '	ui-icon-pencil'
        }        
    });
    
    $("#format").buttonset()
    dialog_permisos = $("#dialog-permisos").dialog({
        autoOpen: false,
        height: 450,
        width: 350,
        modal: true,
        buttons: {
            "Agregar permisos": addUser,
            Cancel: function () {
                dialog_permisos.dialog("close");
            }
        },
        close: function () {
            form[ 0 ].reset();
            allFields.removeClass("ui-state-error");
        }
    });
    $(".btn-agregar-permisos").on("click", function () {
        dialog_permisos.dialog("open");
    });
    
    /***************************************************************************
     * Configuracion de dialog form Direccion
     **************************************************************************/
    dialog_direccion = $("#dialog-direccion").dialog({
        autoOpen: false,
        height: 400,
        width: 350,
        modal: true,
        buttons: {
            "Agregar direccion": addUser,
            Cancel: function () {
                dialog_direccion.dialog("close");
            }
        },
        close: function () {
            form[ 0 ].reset();
            allFields.removeClass("ui-state-error");
        }
    });
    $(".btn-agregar-direccion").button({
         icons: {
            primary: 'ui-icon-plusthick',
            secondary: 'ui-icon-bookmark'
        }        
    });
    $(".btn-quitar-direccion").button({
         icons: {
             primary: 'ui-icon-minusthick'
        }        
    });
    $(".btn-editar-direccion").button({
         icons: {
             primary: '	ui-icon-pencil'
        }        
    });
    $(".btn-agregar-direccion").on("click", function () {
        dialog_direccion.dialog("open");
    });
});