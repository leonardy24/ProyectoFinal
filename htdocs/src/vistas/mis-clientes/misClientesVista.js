import Vista from "../Vista.js";

export default class extends Vista {
    constructor() {
        super()
        this.setTitulo("Mis Clientes")
    }
    
    async getHTML() {
        super.getHTML("/mis-clientes/mis-clientes.html", "/mis-clientes/mis-clientes.js")
    }
}