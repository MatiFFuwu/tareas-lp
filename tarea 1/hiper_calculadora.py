import re

ANS = 0
digito = "[1-9]"
digito_o_zero = "[0-9]"
espacio = "\s*"
div_entera = r"//"
entero = f"\(*({digito}{digito_o_zero}*|0)\)*"
clave = f"\(*ANS|CUPON\({espacio}({entero}|ANS){espacio}(\,{espacio}({entero}|ANS){espacio})?\)\)*"
operador = f"{espacio}([\+\-\*]|{div_entera}){espacio}"
operacion = f"({clave}|{entero}){operador}({clave}|{entero})"
sentencia = f"\(*{espacio}{operacion}\)*\(*({operador}\)*\(*({entero}|{clave}))*{espacio}\)*"

div_cero = f"\(*{espacio}({clave}|{entero})\)*{espacio}{div_entera}{espacio}0{espacio}\)*"

entero_op = f"({digito}{digito_o_zero}*|0)"
clave_op= f"ANS|CUPON\({espacio}({entero_op}|ANS){espacio}(\,{espacio}({entero_op}|ANS){espacio})?\)"
operacion_parentesis = f"\(({clave_op}|{entero_op}){operador}({clave_op}|{entero_op})\)"

operador_1_precedencia = f"{espacio}(\*|{div_entera}){espacio}"
operacion_1_precedencia = f"({clave}|{entero}){operador_1_precedencia}({clave}|{entero})"
operador_2_precedencia = f"{espacio}[\+\-]{espacio}"
operacion_2_precedencia = f"({clave}|{entero}){operador_2_precedencia}({clave}|{entero})"

string = "ANS - CUPON(1200) // 3"
print(re.search(sentencia,string))

def hacer_lista(arch_text): 
    '''
    ***
    * parametro_1 : archivo de texto (.txt) 
    ***
    Crea una lista de todas las lineas del archivo. 
    Retorna una lista de strings
    '''
    with open(arch_text,'r') as archivo:
        lineas = [linea.strip() for linea in archivo.readlines()]
        return lineas

x = hacer_lista("tarea 1/problemas.txt")
print(x)

def lista_problemas(lista): 
    '''
    ***
    * parametro_1 : list
    ***
    Crea una lista de las lineas de un problema hasta el salto de linea del documento; a esta lista de lineas la llamaremos bloque.
    Retorna la susodicha lista de lineas
    '''
    bloque = list()
    for elem in lista:
        if elem != '':
            bloque.append(elem)
        else:
            return bloque
    return bloque

y = lista_problemas(x)
print(y)

def borrar_interseccion(listaOriginal,bloque): 
    '''
    ***
    * parametro_1 : list
    * parametro_2 : list
    ***
    Borra la interseccion entre listaOriginal (la que contiene las lineas de todo el archivo) y bloque.
    Retorna listaOriginal sin las lineas del bloque ingresado por parámetro
    '''
    listaCopia = listaOriginal.copy()
    for elem in listaCopia:
        if elem in bloque:
            listaOriginal.remove(elem)
    if len(listaOriginal)!=0:
        listaOriginal.remove('')
    return listaOriginal

def CUPON(num, descuento=20):
    '''
    ***
    * parametro_1 : int 
    * parametro_2 : int
    ***
    Recibe un número y su descuento (opcional)
    Retorna por defecto el 20% del número. Si se agrega un número, retorna el descuento% del número.
    '''
    return int(num * descuento / 100)

def check_parentesis(string):
    '''
    ***
    * parametro_1 : string
    ***
    Revisa si la expresion tiene misma cantidad de parentesis abiertos y cerrados
    Retorna un booleano True si se cumple lo anterior y False caso contrario.
    '''
    abreParentesis = 0
    cierreParentesis = 0
    for i in string:
        if i == "(":
            abreParentesis = abreParentesis + 1
        elif i == ")":
            cierreParentesis = cierreParentesis + 1
    if abreParentesis - cierreParentesis == 0:
        return True
    else:
        return False

def no_division_cero(string): 
    '''
    ***
    * parametro_1 : string 
    ***
    Revisa si no hay una division en cero.
    Retorna un booleano True si se cumple lo anterior y False caso contrario.
    '''
    if re.search(div_cero,string):
        return False
    else:
        return True
    
def num_con_num(string):
    '''
    ***
    * parametro_1 : string 
    ***
    Revisa si la operacion sigue este orden: <numero> <operador> <numero>
    Retorna un booleano True si se cumple lo anterior y False caso contrario.
    '''
    if re.search(sentencia,string):
        return True    
    else:
        return False
    
def bien_escrito(bloque): 
    '''
    ***
    * parametro_1 : list 
    ***
    Revisa si el bloque está bien escrito a través de las 4 funciones descritas dentro del if como filtro.
    Retorna una lista con cantidad de elementos igual a bloque, siendo 1 o 0: 1 si esta bien escrita la linea y 0 si no.
    '''
    resultado = list()
    for problema in bloque:
        if(check_parentesis(problema) and no_division_cero(problema) and num_con_num(problema)):
            resultado.append(1)    
        else:                
            resultado.append(0)
    return resultado

def combinacion(verificacion,bloque):
    '''
    ***
    * parametro_1 : list 
    * parametro_2 : list
    ***
    Une verificacion (lista de booleanos hecha en bien_escrito) y bloque.
    Retorna una lista con el contenido de ambas, de forma intercalada.
    '''
    intercalado = list()
    for verif,bloq in zip(verificacion,bloque):
        intercalado.extend([verif,bloq])
    return intercalado

def sub_operacion(operador,numeros): 
    '''
    ***
    * parametro_1 : string
    * parametro_2 : list
    ***
    Recibe un operador y una lista de 2 numeros, siguiendo el formato <numero> <operador> <numero>
    Retorna un string con la operacion
    '''
    if numeros[0].strip() == "ANS":
        numeros[0] = ANS
    elif "CUPON" in numeros[0]:
        num_in_cupon = numeros[0].strip().replace("CUPON(","").replace(")","")
        if "," not in num_in_cupon:
            cup = CUPON(int(num_in_cupon))
            numeros[0]=cup
        else:
            list = num_in_cupon.split(",") 
            cup = CUPON(int(list[0]),int(list[1]))
            numeros[0] = cup
    if numeros[1].strip() == "ANS":
        numeros[1] = ANS
    elif "CUPON" in numeros[1]:
        num_in_cupon = numeros[1].strip().replace("CUPON","").replace(")","").replace("(","")
        if "," not in num_in_cupon:
            cup = CUPON(int(num_in_cupon))
            numeros[1]=cup
        else:
            list = num_in_cupon.split(",") 
            cup = CUPON(int(list[0]),int(list[1]))
            numeros[1] = cup
    if operador == "*":
        resultado = int(numeros[0]) * int(numeros[1])
        return str(resultado)
    elif operador == "//":
        resultado = int(numeros[0]) // int(numeros[1])
        return str(resultado)
    elif operador == "+":
        resultado = int(numeros[0]) + int(numeros[1])
        return str(resultado)
    elif operador == "-":
        resultado = int(numeros[0]) - int(numeros[1])
        if resultado < 0:
            resultado = 0
        return str(resultado)

def string_a_realizar(string):
    '''
    ***
    * parametro_1 : string 
    ***
    Recibe un string sin parentesis.
    Retorna el sub string dentro de string con mayor precedencia.
    '''
    if "*" in string or "//" in string:
        operacion = re.search(operacion_1_precedencia,string)
    elif "+" in string or "-" in string:
        operacion = re.search(operacion_2_precedencia,string)
    return operacion.group()

def realizar_operacion(string): 
    '''
    ***
    * parametro_1 : string
    ***
    Recibe un string y realiza la operacion de tipo <numero> <operador> <numero>
    Retorna el string original con la operacion realizada reemplazada
    '''
    op_parentesis = re.search(operacion_parentesis,string)
    op_sin_parentesis1 = re.search(operacion_1_precedencia,string)
    op_sin_parentesis2 = re.search(operacion_2_precedencia,string)
    if op_parentesis:
        str0 = op_parentesis.group()
        newstr = str0.replace("(","")
        newstr2 = newstr.replace(")","")
        oper = re.search(operador,newstr2)
        newoper = oper.group().strip()
        numeros = newstr2.split(newoper)
        resultado = sub_operacion(newoper,numeros)
        finalstr = string.replace(str0,resultado)
        return finalstr
    elif op_sin_parentesis1 or op_sin_parentesis2:
        if "CUPON" in string:
            substring = string_a_realizar(string)
        else:
            substring = string_a_realizar(string).strip("()")
        oper = re.search(operador,substring)
        newoper = oper.group().strip()
        numeros = substring.split(newoper)
        resultado = sub_operacion(newoper,numeros)
        finalstr = string.replace(substring,resultado)
        return finalstr

def escribir(intercalado,resultado):  #[1,'2500 + 1200',1,'ANS + 860 * 6',1,'ANS // 3']
    '''
    ***
    * parametro_1 : list 
    * parametro_2 : archivo de texto (.txt)
    ***
    Verifica si hay algun error en una linea. De ser así, las escribe como sin resolver o error. Caso contrario escribe el valor final de la operacion
    No retorna nada.
    '''
    i = 0  
    if 0 in intercalado:
        while i < len(intercalado)/2:
            if intercalado[2*i]==0:
                resultado.write(intercalado[2*i+1] + " =" + " Error" + "\n")
            elif intercalado[2*i]==1:
                resultado.write(intercalado[2*i+1] + " =" + " Sin Resolver" + "\n")
            i = i + 1
        resultado.write("\n")
    else:
        i = 0
        while i < len(intercalado)/2:
            problema = intercalado[2*i+1]
            while realizar_operacion(problema) != None:
                problema = realizar_operacion(problema)
                if re.search(operacion,problema) == None:
                    global ANS 
                    ANS = int(problema)
            resultado.write(intercalado[2*i+1] + " = " + str(ANS) + "\n")
            i = i + 1
        ANS = 0
        resultado.write("\n")

primeraLista = hacer_lista("tarea 1/problemas.txt") 
bloque = lista_problemas(primeraLista)
listaActualizada = borrar_interseccion(primeraLista,bloque)
with open("desarrollos.txt", 'w') as resultado: 
    while len(bloque)!=0:
        verificacion = bien_escrito(bloque)
        print(verificacion)
        union = combinacion(verificacion,bloque)
        print(union)
        escribir(union,resultado)
        bloque = lista_problemas(listaActualizada)
        listaActualizada = borrar_interseccion(listaActualizada,bloque)