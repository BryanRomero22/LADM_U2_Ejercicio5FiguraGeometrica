package mx.edu.ittepic.ladm_u2_ejercicio5figurageometrica

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    // se requiere p para que view sepa cual activity va a trabajar
    var puntero = p
    /*var cx = 150f
    var cy = 150f
    var tx = 733f
    var ty = 818f*/
    var circulo = FiguraGeometrica(150, 150, 10)
    var circulo2 = FiguraGeometrica(500, 1300, 30)
    var circulo3 = FiguraGeometrica(100, 1200, 50)
    var circulo4 = FiguraGeometrica(500, 10, 70)
    var circulo5 = FiguraGeometrica(50, 800, 90)
    var circulo6 = FiguraGeometrica(10, 1000, 150)
    var punteroFiguraGeometrica: FiguraGeometrica? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()

        canvas.drawColor(Color.BLACK)

        //Dibujando un círculo rojo con contorno blanco
        paint.color = Color.RED
        circulo.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo.pintar(canvas, paint)

        //Dibujando 2do ciculo
        paint.color = Color.MAGENTA
        circulo2.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo2.pintar(canvas, paint)

        //Dibujando 3ro ciculo
        paint.color = Color.BLUE
        circulo3.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo3.pintar(canvas, paint)

        //Dibujando 4to ciculo
        paint.color = Color.YELLOW
        circulo4.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo4.pintar(canvas, paint)

        //Dibujando 5to ciculo
        paint.color = Color.WHITE
        circulo5.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo5.pintar(canvas, paint)

        //Dibujando 6to ciculo
        paint.color = Color.GRAY
        circulo6.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo6.pintar(canvas, paint)
    }

    /*override fun onTouchEvent(event: MotionEvent): Boolean {
        puntero.setTitle("")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //REVISAMOS QUIEN ESTA EN AREA
                if (circulo.estaEnArea(event)) {
                    punteroFiguraGeometrica = circulo
                    puntero.setTitle("TOCASTE CIRCULO")
                }
                if (circulo2.estaEnArea(event)) {
                    punteroFiguraGeometrica = circulo2
                    puntero.setTitle("TOCASTE CIRCULO2")
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (punteroFiguraGeometrica != null) {
                    punteroFiguraGeometrica!!.arrastrar(event)
                }

            }
            MotionEvent.ACTION_UP -> {
                punteroFiguraGeometrica = null
            }
        }
        invalidate()
        return true
    }*/

    fun animarCirculo() {
        circulo.rebote(width, height)
        circulo2.rebote(width, height)
        circulo3.rebote(width, height)
        circulo4.rebote(width, height)
        circulo5.rebote(width, height)
        circulo6.rebote(width, height)

        invalidate()
    }

}