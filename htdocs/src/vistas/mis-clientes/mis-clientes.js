function escucharClickLlamarCliente() {
    const botonLlamar = document.getElementById("boton-llamar-cliente")
    botonLlamar.addEventListener("click", (_event) => {



        const idGestor = getIdUsuario()

        if (idGestor == null) {
            alert("NO HAS INICIADO SESION!")
        } else {
            
            console.log("clikkk")

            fetch('http://localhost:8080/cliente/gestor/'+ idGestor)
                .then(response => response.json())
                .then(clientes => {

                    console.log({ clientes })

                    let tablaCliente = ""




                    for (cliente of clientes) {
                        let idCliente = cliente.id
                        let correo = cliente.correo
                        let password = cliente.password
                        let saldo = cliente.saldo
                        let usuario = cliente.usuario
                        



                        tablaCliente += "<div>" + "Id:" + idCliente + "   " + "Correo :" + correo + "   " + "Password:" + password + "  " + "Saldo:" + saldo + "  " + "Usuario:" + usuario + "  " +  "</div>"
                    }


                    const contenedorUsuario = document.getElementById("contenedor-clientes")
                    contenedorUsuario.innerHTML = tablaCliente



                })

        }

    })


}

function getIdUsuario(){

    const usuarioGuardado= sessionStorage.getItem("miUsuario")


    if(usuarioGuardado == null){
        return null
    }else{
        const miUsuario=JSON.parse(usuarioGuardado)
        return miUsuario.id
    }
}




escucharClickLlamarCliente()