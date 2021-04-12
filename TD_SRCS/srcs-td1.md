# TD1 SRCS 29-01-2021

## Exercice 1




3 -
ctrl-d pour terminer le programme, et non ctrl-c
```java

try (OutputStream out = new FileOutpuStream("/tmp/f")){
    IOBinding.bind(System.in, out);
}
```

## Exercice 2

1 - 

```java

public class CesarOutputStream( extends FilterOutputSream {

    private final int key;

    public CesarOutputStream(OutputSteam out, int key){
        super(out);
        this.key = key;
    }
}

// TESTS
public class Exo2Q1 {
    public static void main(String[] args) throws IOException{
        IOBinding.bind(System.in, new CesarOutputStream(System.out, 5));
    }
}
```

4 - 
