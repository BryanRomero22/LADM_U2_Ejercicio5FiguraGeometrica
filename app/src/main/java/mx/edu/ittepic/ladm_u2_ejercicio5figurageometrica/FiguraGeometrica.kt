package mx.edu.ittepic.ladm_u2_ejercicio5figurageometrica

import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent

class FiguraGeometrica () {
    var x = 0f
    var y = 0f
    var tipo = 1 //1 circulo 2 rectangulo
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incX = 0
    var incY = 0

    constructor(x:Int, y:Int, radio:Int) : this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio = radio.toFloat()
        if(radio >= 0 && radio <= 20){
            incX = 50
            incY = 50
        }
        else if(radio >= 21 && radio <= 40){
            incX = 40
            incY = 40
        }
        else if(radio >= 41 && radio <= 60){
            incX = 30
            incY = 30
        }
        else if(radio >= 61 && radio <= 80){
            incX = 20
            incY = 20
        }
        else if(radio >= 81 && radio <= 100){
            incX = 10
            incY = 10
        }
        else if(radio >= 102){
            incX = 1
            incY = 1
        }
    }

    constructor(x:Int, y:Int, ancho:Int, alto:Int) : this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.ancho = ancho.toFloat()
        this.alto = alto.toFloat()
        tipo = 2
    }

    fun pintar(c: Canvas, p: Paint){
        when(tipo){
            1->{
                c.drawCircle(x,y,radio,p)
            }
            2->{
                c.drawRect(x,y,x+ancho,y+alto,p)
            }
        }
    }

    fun estaEnArea(event: MotionEvent):Boolean{
        when(tipo){
            1->{
                if(event.x>=x-radio && event.x<=x+radio){
                    if(event.y>=y-radio && event.y<=y+radio){
                        return true
                    }
                }
            }
            2->{
                if(event.x >= x && event.x<=x+ancho){
                    if(event.y >= y && event.y<=y+alto){
                        return true
                    }
                }
            }
        }
        return false
    }

    fun arrastrar(event: MotionEvent){
        when(tipo){
            1->{
                x = event.x
                y = event.y
            }
            2->{
                x = event.x - (ancho/2)
                y = event.y - (alto/2)
            }
        }

    }

    fun rebote(ancho:Int, alto:Int){
        x+= incX
        if(x<=-100 || x>=ancho){
            incX *= -1
        }
        y+= incY
        if(y<=-100 || y>=alto){
            incY *= -1
        }

    }



}