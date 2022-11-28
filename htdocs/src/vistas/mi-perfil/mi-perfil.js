function getMiPerfil(){

    const usuarioGuardado= sessionStorage.getItem("miUsuario")

    if(usuarioGuardado==null){
        alert("NO HAS INICIADO SESION!")
    }else{
        const miUsuario= JSON.parse(usuarioGuardado)
   
      
    const idGestor=miUsuario.id    
    fetch('http://localhost:8080/gestor/' + idGestor)
    .then(response =>response.json())
    .then(gestor =>{

    console.log({gestor})
    //inserta nombre usuario en HTML
    const contenedorUsuario = document.getElementById("contenedor-username")
    contenedorUsuario.innerHTML = gestor.usuario
    //insertamos correo en HTML
    const contenedorCorreo = document.getElementById("contenedor-correo")
    contenedorCorreo.innerHTML= gestor.correo
    //insertamos id
    const contenedorId = document.getElementById("contenedor-id") 
    contenedorId.innerHTML = gestor.id

        const contenedorImg = document.getElementById("imagenPerfil")
        contenedorImg.setAttribute("src", gestor.imagenUrl )

    })
    escucharClickBotonCerraSesion()
}

}
    getMiPerfil()

    function escucharClickBotonCerraSesion(){

        const botonCerrar= document.getElementById("btn-cerra")

        botonCerrar.addEventListener("click",(_event)=>{

        sessionStorage.clear()
        alert("se ha cerrado sesion")
    })




    }



    function cerrarSesion(){

    }