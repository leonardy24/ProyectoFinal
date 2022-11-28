import InicioVista from "./vistas/inicio/InicioVista.js"
import loginVista from "./vistas/login/loginVista.js"
import MiPerfilVistas from "./vistas/mi-perfil/MiPerfilVistas.js"
import misClientesVista from "./vistas/mis-clientes/misClientesVista.js"
import misMensajeVista from "./vistas/mis-mensajes/misMensajeVista.js"
import NotFoundVista from "./vistas/not-found/NotFoundVista.js"
import nuevoClienteVista from "./vistas/nuevo-cliente/nuevoClienteVista.js"
import nuevoGestorVista from "./vistas/nuevo-gestor/nuevoGestorVista.js"

// para controlar las rutas de la aplicación
const router = async () => {
    // nuestras rutas
    const rutas = [
        // indicamos la ruta y la clase para cargar la vista
        { path: "/not-found", view: NotFoundVista, hasLogin:false },
        { path: "/", view: InicioVista, hasLogin: true },
        { path: "/mi-perfil", view: MiPerfilVistas ,hasLogin: true},
        { path: "/nuevo-gestor", view: nuevoGestorVista ,hasLogin: true },
        { path: "/nuevo-cliente", view: nuevoClienteVista, hasLogin: true },
        { path: "/login", view: loginVista, hasLogin:false },
        { path: "/mis-clientes", view: misClientesVista, hasLogin:false },
        { path: "/mis-mensajes", view: misMensajeVista, hasLogin:false },




    ]

    // la ruta que cargaremos si se intenta navegar a una que no existe
    const rutaPorDefecto = rutas[0]

    // comparamos las rutas con la ruta actual (location.pathname)
    const rutasCoinciden = rutas.map((ruta) => {
        return {
            ruta: ruta,
            coincide: location.pathname === ruta.path
        }
    })

    // buscamos la primera que coincida
    let rutaActual = rutasCoinciden.find(ruta => ruta.coincide)

    // si ninguna coincide usamos la ruta por defecto
    if (!rutaActual) {
        console.log("404 Not found, redirigiendo a ruta por defecto...")
        rutaActual = {
            ruta: rutaPorDefecto,
            coincide: true
        }
    }

    //comprobar si el usuario ha iniciado sesion
    if(rutaActual.ruta.hasLogin){
        const usuarioGuardado=sessionStorage.getItem("miUsuario")
        if(usuarioGuardado==null){
            navegarA("/login")
            return
        }
    }

    // preparamos la vista actual creando un nuevo objeto de la clase de la vista
    const vistaActual = new rutaActual.ruta.view()

    // obtenemos el contenido de la vista y lo cargamos en el contenedor de página
    // usamos await porque getHTML es una función asíncrona (async)
    await vistaActual.getHTML()

    console.log({ rutaActual })

}

// para navegar a una url
const navegarA = (url) => {
    // indica al navegador que se navega a url para poder volver atrás, recargar página...etc
    history.pushState(null, null, url)
    // procesa la ruta a la que navegar
    router()
}

// esperamos a que el HTML del index esté cargado
document.addEventListener("DOMContentLoaded", () => {
    // escuchamos cualquier evento click en la página
    document.body.addEventListener("click", event => {
        // si el elemento en el que hacemos click tiene el atributo data-app-link
        if (event.target.matches("[data-app-link]")) {
            // evitamos la navegación por defecto y utilizamos la nuestra
            // así podemos elegir si los enlaces funcionan normalmente o con nuestra navegación
            event.preventDefault()
            navegarA(event.target.href)
        }
    })
    // procesamos la ruta al cargar la aplicación
    router()
})