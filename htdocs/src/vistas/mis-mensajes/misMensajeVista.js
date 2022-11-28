import Vista from "../Vista.js";

export default class extends Vista {
    constructor() {
        super()
        this.setTitulo("Mis Mensajes")
    }
    
    async getHTML() {
        super.getHTML("/mis-mensajes/mis-mensajes.html", "/mis-mensajes/mis-mensajes.js")
    }
}