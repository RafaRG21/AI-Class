# -*- coding: utf-8 -*-
"""
Created on Tue Nov 22 09:31:37 2022

@author: Rafael Gudiño
"""

import math
import pandas as pd
df = pd.read_csv("C:/Users/Usuario/Documents/calificaciones.csv")
print(df)
#identificar el tamaño de la bd
tam = df.shape
print(tam)
#cuantos renglones
renglones = df.shape[0]
columnas = df.shape[1]
print("renglones: ",renglones,"Columnas: ",columnas)

#Cuantas etiquetas tenemos en nota
print(df["Nota"].value_counts())
print('\n')
df.info()

#Empezamos a programar ID3

def calcular_Entropia(df,renglones):
    entropia = 0 #N elementos feactures olnly fesactues
    clases = df["Nota"].value_counts().keys().tolist()
    print(clases)
    for i in range(0,len(clases)):
        probabilidad_clase = df.iloc[:,-1].value_counts().tolist()[i]/renglones
        print(probabilidad_clase)
        entropia = entropia - probabilidad_clase*math.log(probabilidad_clase,2)
        print("entropia: ",entropia)
        return entropia
    
def entropia_clases(df):
    ganancias = []
    for i in range(0,columnas-1):
        nombre_atributo = df.columns[i]
        clases_atributos = df[nombre_atributo].value_counts()
        ganancia =  entropia
        for j in range(0,len(clases_atributos)):
            clase_actual = clases_atributos.keys().tolist()[j]
            subdata = df[df[nombre_atributo]==clase_actual]
            subdata_entropia = calcular_Entropia(subdata, subdata.shape[0])
            
for i in range(0,columnas-1):
    nombre_atributo = df.columns
    
entropia = calcular_Entropia(df, renglones)