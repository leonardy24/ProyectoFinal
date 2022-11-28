import Vista from "../Vista.js";


export default class extends Vista {
    constructor(){
        super()
        this.setTitulo("Nuevo Gestor")
    }

     // sobreescribimos la función getHTML y llamamos a la del padre Vista
     async getHTML() {
        super.getHTML("/nuevo-gestor/nuevo-gestor.html", "/nuevo-gestor/nuevo-gestor.js")
    }


}