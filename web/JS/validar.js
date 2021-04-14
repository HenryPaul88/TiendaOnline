function validarString(cadena, min, max) {
    var res = false;
    if (min == 0 && max != null) {
        if ((isNaN(cadena) && cadena.length <= max) || cadena == "")
            res = true;
    }
    if (min > 0 && max == null) {
        if (isNaN(cadena) && cadena.length >= min)
            res = true;
    }
    if (min == 0 && max == null) {
        if (isNaN(cadena) || cadena == "")
            res = true;
    }
    if (min > 0 && max != null) {
        if (isNaN(cadena) && cadena.length >= min && cadena.length <= max)
            res = true;
    }
    return res;
}

function esVacio(valor) {
    if (valor == "") {
        return true;
    } else {
        return false;
    }

}

function validarTelefono(cadena, min, max) {
    if (cadena.substring(0, 1) == 6 || cadena.substring(0, 1) == 7 ||
        cadena.substring(0, 1) == 9) {
        if (!isNaN(cadena) && cadena.length >= min && cadena.length <= max) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

function validarEmail(valor) {
    if (valor != "") {
        var expresion = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/;
        if (!expresion.test(valor)) {
            return false;
        } else {
            return true;
        }
    }
}

function validarPC(cadena, min, max) {
    if (!isNaN(cadena) && cadena.length >= min && cadena.length <= max) {
        return true;
    } else {

        return false;
    }
}

function crearCaptcha() {

    var num1 = Math.round(Math.random() * 9);
    var num2 = Math.round(Math.random() * 9);

    document.getElementById("num1").innerHTML = num1.toString();
    document.getElementById("num2").innerHTML = num2.toString();

}

function validar_clave(contrasenna) {
    if (contrasenna.length >= 8) {
        var mayuscula = false;
        var minuscula = false;
        var numero = false;
        var caracter_raro = false;

        for (var i = 0; i < contrasenna.length; i++) {
            if (contrasenna.charCodeAt(i) >= 65 && contrasenna.charCodeAt(i) <= 90) {
                mayuscula = true;
            } else if (contrasenna.charCodeAt(i) >= 97 && contrasenna.charCodeAt(i) <= 122) {
                minuscula = true;
            } else if (contrasenna.charCodeAt(i) >= 48 && contrasenna.charCodeAt(i) <= 57) {
                numero = true;
            } else {
                caracter_raro = true;
            }
        }
        if (mayuscula == true && minuscula == true && caracter_raro == true && numero == true) {
            return true;
        }
    }
    return false;
}

function validarCaptcha(elemento) {

    var num1 = document.getElementById("num1").innerHTML;
    var num2 = document.getElementById("num2").innerHTML;
    var resultado;
    resultado = parseInt(num1) + parseInt(num2);

    if (resultado != elemento) {
        return false;
    } else {
        return true;
    }
}