public class MiHashMap
{
    // Array para guardar las claves
    private String[] claves;
    // Array para guardar los valores
    private int[] valores;

    /**
     * Constructor de objetos de la clase MiHashMap
     */
    public MiHashMap()
    {
        claves = new String[0];
        valores = new int[0];
    }

    /**
     * Método que asocia el valor especificado con la calve especificada. Si la clave existía
     * entonces sobrescribe su valor y devuelve el valor antiguo. Si no existe devuelve -1
     */
    public int put(String clave, int valor)
    {
        int index = 0;
        boolean claveRepetida = false;
        while (index<valores.length && !claveRepetida ) {
            if (clave.equals(claves[index])) {
                claveRepetida = true;
                valores[index] = valor;
            }
            index++;
        }
        if (!claveRepetida) {
            index = -1;
            int cont = 0;
            String[] nuevasClaves = new String[claves.length + 1];
            int[] nuevosValores = new int[valores.length + 1];
            while (cont<claves.length) {
                nuevasClaves[cont] = claves[cont];
                nuevosValores[cont] = valores[cont];
                cont++;
            }
            nuevasClaves[nuevasClaves.length - 1] = clave;
            nuevosValores[nuevosValores.length - 1] = valor;
            claves = nuevasClaves;
            valores = nuevosValores;
        }
        return index;
    }

    /**
     * Método que devuelve el valor asociado con la clave especificada o -1 en caso de que la clave no exista.
     */
    public int get(String clave)
    {
        int index = -1;
        int cont = 0;
        boolean claveEncontrada = false;
        while (cont<claves.length && !claveEncontrada) {
            if (claves[cont].equals(clave)) {
                index = valores[cont];
                claveEncontrada = true;
            }
            cont++;
        }
        return index;
    }

    /**
     * Método que devuelve true si el mapa no contiene elementos.
     */
    public boolean isEmpty()
    {
        return (claves.length==0);
    }

    /**
     * Método que devuelve el número de elementos del mapa.
     */
    public int size()
    {
        return claves.length;
    }

    /**
     * Método que elimina del mapa el elemento con la clave dada y devuelve su valor. 
     * Si no hay esa clave en el mapa devuelve -1.
     */
    public int remove(String clave)
    {
        int index = 0;
        int valorEliminado = -1;
        boolean claveEncontrada = false;

        while(index<claves.length && claveEncontrada) {
            if (claves[index].equals(clave)) {
                claveEncontrada = true;
                valorEliminado = valores[index];  
                String[] nuevasClaves = new String[claves.length - 1];
                int[] nuevosValores = new int[valores.length - 1];
                int cont = 0;
                while(cont<index) {
                    nuevasClaves[cont] = claves[cont];
                    nuevosValores[cont] = valores[cont];
                    cont++;
                }
                while (cont<nuevasClaves.length) {
                    nuevasClaves[cont] = claves[cont];
                    nuevosValores[cont] = valores[cont];
                    cont++;
                }
                claves = nuevasClaves;
                valores = nuevosValores;
            }
            index++;
        }
        return valorEliminado;
    }

    /**
     * Método que vacia el mapa
     */
    public void clear()
    {
        claves = new String[0];
        valores = new int[0];
    }
    
    /**
     * Método que devuelve true si el mapa contiene la clave dada.
     */
    public boolean containsKey(String clave)
    {
        boolean claveEncontrada = false;
        int index = 0;
        while (index<claves.length && !claveEncontrada) {
            if (claves[index].equals(clave)) {
                claveEncontrada = true;
            }
            index++;
        }
        return claveEncontrada;
    }
}

