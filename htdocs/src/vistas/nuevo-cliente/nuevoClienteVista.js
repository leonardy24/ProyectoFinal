import Vista from "../Vista.js";
    
export default class extends Vista{
    constructor(){
        super()
        this.setTitulo("Nuevo Cliente")
    }


    async getHTML(){
        super.getHTML("/nuevo-cliente/nuevo-cliente.html", "/nuevo-cliente/nuevo-cliente.js")
    }



}