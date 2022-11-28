function escucharClickLlamarMensajes(){
    const botonLlamarMensaje = document.getElementById("boton-llamar-mensaje")
    botonLlamarMensaje.addEventListener("click", (_event)=>{



        const idGestor =getIdMensaje()

        if(idGestor==null){
            alert("NO HAS INICIADO SESION")
        }else{



        fetch('http://localhost:8080/mensaje/mensajes-recibidos/'+ idGestor)
        .then(response=>response.json())
        .then(mensajes =>{

        console.log({mensajes})

        let tablaMensaje=""

        for(mensaje of mensajes){
            let idMensaje = mensaje.id
            let fechaMensaje= mensaje.fecha
            let textoMensaje = mensaje.texto
            let idOrigen = mensaje.gestorOrigen
            let idDestino = mensaje.gestorDestino

            tablaMensaje += "<div>" + "Id:" + idMensaje + "   " + "Fecha :" + fechaMensaje + "   " + "Mensaje:" + textoMensaje + "  " + "Id Origen:" + idOrigen.usuario+ "  "+"Id Destino:" + idDestino.usuario+"</div>"

        }

        const contenedorMensajes = document.getElementById("contenedor-mensajes")
        contenedorMensajes.innerHTML = tablaMensaje


        })

    }

    })


}

function getIdMensaje(){

    const usuarioGuardado = sessionStorage.getItem("miUsuario")

    if(usuarioGuardado== null){
        return null
    }else{
        const miUsuario = JSON.parse(usuarioGuardado)
        return miUsuario.id
    }

}


escucharClickLlamarMensajes()