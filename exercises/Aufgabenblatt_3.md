# Aufgabenblatt 3 - O-Notation

## Aufgabe 1: Komplexitätsklassen
Füllen Sie die folgende Tabelle mit den unterschiedlichen Funktionswerten für die angegebenen Werte für n aus, 
mindestens so weit Ihr Taschenrechner reicht. Welche Schlussfolgerungen können Sie aus den Werten in der Tabelle auf 
die Laufzeit von Algorithmen ziehen?

|    n     | $`log_2 n`$ | $`\sqrt{n}`$ | $`n log_2 n`$ | $`n^2`$ | $`n^3`$ | $`2^n`$ | $`3^n`$ |
|:--------:|:-----------:|:------------:|:-------------:|:-------:|:-------:|:-------:|:-------:|
|    16    |             |              |               |         |         |         |         | 
|    64    |             |              |               |         |         |         |         |
|   256    |             |              |               |         |         |         |         |
|   1024   |             |              |               |         |         |         |         |
| $`2^20`$ |             |              |               |         |         |         |         |

## Aufgabe 2: O-Notation
Zeigen Sie, dass die folgenden Aussagen wahr sind oder widerlegen Sie sie. Begründen Sie Ihre Entscheidung und geben Sie 
bei wahren Aussagen ein geeignetes c und n<sub>0</sub> an.

1. $`27 \in O(1)`$ 
2. $`\frac{n (n - 1)}{2} \in O ( n^2 )`$ 
3. $`max(n^3,10n^2) \in O(n^2)`$ 
4. $`log n \in \Omega(n)`$ 
5. $`2n+4 \in \Theta(n)`$ 

## Aufgabe 3: Codeanalyse
Bestimmen Sie zunächst die Anzahl elementarer Rechenschritte wie Vergleiche, Zuweisungen und arithmetischer Operationen 
für die folgenden Codestücke in Abhängigkeit von der Anzahl n „beteiligter“ Elemente. Die zu betrachtenden 
Elementarschritte sind jeweils angegeben. Geben Sie dann den Aufwand in O-Notation an.

1. Vertauschen zweier Feldelemente: (Anzahl der Zuweisungen?)

```java
class CodeAnalysis {
   static void exchange(int[] array, int index1, int index2) {
       array[index1] = array[index1] + array[index2];
       array[index2] = array[index1] - array[index2];
       array[index1] = array[index1] - array[index2];
   }
}
```

2. Suche des Minimums in einem Array: (Anzahl der Vergleiche?)

```java
class CodeAnalysis {
   static int minimum(int[] array) {
      int minimum = array[0];
      int index = 1;
      while (index < array.length) {
         if (array[index] < minimum) {
            minimum = array[index];
         }
         index++;
      }
      return minimum;
   }
}
```
   
3. Suche eines Wertes in einem sortierten Array: (Anzahl der Vergleiche?)

```java
class CodeAnalysis {
   static int indexOfValue(int[] array, int value) {
      int from = 0;
      int to = array.length - 1;
      int middle;
      while (from <= to) {
         middle = (from + to) / 2;
         if (value < array[middle]) {
            to = middle - 1;
         } else if (value > array[middle]) {
            from = middle + 1;
         } else {
            return middle;
         }
      }
      return -1;
   }
}
```

## Aufgabe 4: O-Notation
Die folgende Funktion implementiert die Suche eines Wertes in einem sortierten Array. Bestimmen Sie zunächst die 
rekursive Aufwandsfunktion für die Anzahl der erforderlichen Vergleiche und be- stimmen Sie dann die Komplexität der 
Funktion in O-Notation.

```java
class CodeAnalysis {
   static int indexOfRecursive(int[] array, int value, int from, int to) {
      int middle;
      if (from <= to) {
         middle = (from + to) / 2;
         if (value < array[middle]) {
            return indexOfRecursive(array, value, from, middle - 1);
         } else if (value > array[middle]) {
            return indexOfRecursive(array, value, middle + 1, to);
         } else {
            return middle;
         }
      }
      return -1;
   }
}
```
