import Vista from "../Vista.js";


export default class extends Vista {
    constructor(){

    super()
    this.setTitulo("Mi perfil")
    }

    // sobreescribimos la función getHTML y llamamos a la del padre Vista
    async getHTML() {
        super.getHTML("/mi-perfil/mi-perfil.html", "/mi-perfil/mi-perfil.js")
    }





}