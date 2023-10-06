JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
MAIN = Juego

CLASSES = \
        Amarillo.java \
		Cyan.java \
		Enemigo.java \
		ILevantar.java \
		Juego.java \
        Magenta.java \
        Muralla.java \
        Pieza.java \
		Pikinim.java \
		Pildora.java \
		Zona.java \

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	java $(MAIN)
clean:
	$(RM) *.class
