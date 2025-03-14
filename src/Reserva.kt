class Reserva {
    var id: String = ""
    var idHuesped: String = ""
    var nombreHuesped: String = ""
    var emailHuesped: String = ""
    var numeroHabitacion: Int = 0
    var tipoHabitacion: String = ""
    var precioPorNoche: Double = 0.0
    var cantidadNoches: Int = 0

    constructor(id: String, idHuesped: String, nombreHuesped: String, emailHuesped: String,
                numeroHabitacion: Int, tipoHabitacion: String, precioPorNoche: Double, cantidadNoches: Int) {
        this.id = id
        this.idHuesped = idHuesped
        this.nombreHuesped = nombreHuesped
        this.emailHuesped = emailHuesped
        this.numeroHabitacion = numeroHabitacion
        this.tipoHabitacion = tipoHabitacion
        this.precioPorNoche = precioPorNoche
        this.cantidadNoches = cantidadNoches
    }

    fun calcularTotal(): Double {
        return precioPorNoche * cantidadNoches
    }
}