function mostrar(elemento) {
    elemento.style.display = "block";
}

function noMostrar(elemento) {
    elemento.style.display = "none";
}

function validarStringInside(elemento, min, max, capaerror) {
    if (!validarString(elemento.value, min, max)) {
        if (!esVacio(elemento)) {
            elemento.style.borderColor = "red";
            mostrar(capaerror);
        }

    } else {
        elemento.style.backgroundColor = "";
        elemento.style.borderColor = "green";
        noMostrar(capaerror);
    }
}

function validarNUmeroDigitosInside(elemento, min, max, capaerror) {
    if (!validarPC(elemento.value, min, max)) {
        elemento.style.borderColor = "red";
        mostrar(capaerror);
    } else {
        noMostrar(capaerror);
        elemento.style.borderColor = "green";
        elemento.style.backgroundColor = "";

    }
}

function validarclaveInside(elemento, capaerror) {
    if (!validar_clave(elemento.value)) {
        elemento.style.borderColor = "red";
        mostrar(capaerror);
    } else {
        noMostrar(capaerror);
        elemento.style.backgroundColor = "";
        elemento.style.borderColor = "green";
    }
}

function validarEmailInside(elemento, capaerror) {
    if (!validarEmail(elemento.value)) {
        elemento.style.borderColor = "red";
        mostrar(capaerror);
    } else {
        noMostrar(capaerror);
        elemento.style.backgroundColor = "";
        elemento.style.borderColor = "green";
    }
}

function validarTelefonoInside(elemento, min, max, capaerror) {
    if (!validarTelefono(elemento.value, min, max)) {
        elemento.style.borderColor = "red";
        mostrar(capaerror);
    } else {
        noMostrar(capaerror);
        elemento.style.backgroundColor = "";
        elemento.style.borderColor = "green";
    }
}

function validarCaptchaIndise(elemento, capaerror) {
    if (!validarCaptcha(elemento.value)) {
        if (!esVacio(elemento)) {
            elemento.style.borderColor = "red";
            mostrar(capaerror);
        }
    } else {
        elemento.style.borderColor = "green";
        noMostrar(capaerror);
    }
}
