val listaReservas = mutableListOf<Reserva>()

fun registrarReserva(): Boolean {
    println("=== REGISTRAR NUEVA RESERVA ===")

    print("Ingrese ID de la reserva: ")
    val idReserva = readLine() ?: ""

    print("Ingrese ID del huésped: ")
    val idHuesped = readLine() ?: ""

    print("Ingrese Nombre del huésped: ")
    val nombreHuesped = readLine() ?: ""

    print("Ingrese el correo del huésped: ")
    val emailHuesped = readLine() ?: ""

    print("Ingrese número de habitación: ")
    val numeroHabitacionStr = readLine() ?: ""
    val numeroHabitacion = numeroHabitacionStr.toIntOrNull() ?: 0

    print("Ingrese tipo de habitación: ")
    val tipoHabitacion = readLine() ?: ""

    print("Ingrese precio por noche: ")
    val precioPorNocheStr = readLine() ?: ""
    val precioPorNoche = precioPorNocheStr.toDoubleOrNull() ?: 0.0

    print("Ingrese cantidad de noches Reservadas: ")
    val cantidadNochesStr = readLine() ?: ""
    val cantidadNoches = cantidadNochesStr.toIntOrNull() ?: 0

    val nuevaReserva = Reserva(idReserva, idHuesped, nombreHuesped, emailHuesped,
        numeroHabitacion, tipoHabitacion, precioPorNoche, cantidadNoches)

    for (r in listaReservas) {
        if (r.numeroHabitacion == numeroHabitacion) {
            println("Error: La habitación ya está reservada")
            return false
        }
    }

    listaReservas.add(nuevaReserva)
    println("Reserva registrada exitosamente")
    return true
}

fun cancelarReserva(): Boolean {
    println("=== CANCELAR RESERVA ===")
    print("Ingrese ID de la reserva a cancelar: ")
    val idReserva = readLine() ?: ""

    var i = 0
    while (i < listaReservas.size) {
        if (listaReservas[i].id == idReserva) {
            listaReservas.removeAt(i)
            println("Reserva cancelada exitosamente")
            return true
        }
        i++
    }

    println("Error: No se encontró la reserva con ID $idReserva")
    return false
}

fun mostrarReservas() {
    println("=== RESERVAS ACTIVAS ===")

    if (listaReservas.size == 0) {
        println("No hay reservas activas")
        return
    }

    var i = 0
    while (i < listaReservas.size) {
        val reserva = listaReservas[i]
        println("-----------------------")
        println("ID Reserva: ${reserva.id}")
        println("ID Huésped: ${reserva.idHuesped}")
        println("Nombre: ${reserva.nombreHuesped}")
        println("Email: ${reserva.emailHuesped}")
        println("Habitación: ${reserva.numeroHabitacion}")
        println("Tipo: ${reserva.tipoHabitacion}")
        println("Precio por noche: ${reserva.precioPorNoche}")
        println("Noches: ${reserva.cantidadNoches}")
        println("Total a pagar: ${reserva.calcularTotal()}")
        println("-----------------------")
        i++
    }
}

fun main() {
    var seguir = true

    while (seguir) {
        println("\n=== RESERVAS DE HABITACIONES HOTEL ===")
        println("1. Registrar una reserva")
        println("2. Cancelar una reserva")
        println("3. Mostrar todas las reservas activas")
        println("4. Salir")
        print("SELECCIONE LA OPCION DE SU PREFERENCIA: ")



        val opcionStr = readLine() ?: ""
        val opcion = opcionStr.toIntOrNull() ?: 0

        if (opcion == 1) {
            registrarReserva()
        } else if (opcion == 2) {
            cancelarReserva()
        } else if (opcion == 3) {
            mostrarReservas()
        } else if (opcion == 4) {
            println("Saliendo del sistema...")
            seguir = false
        } else {
            println("Opción inválida, intente de nuevo")
        }
    }
}