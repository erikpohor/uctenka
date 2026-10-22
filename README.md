# EasyReceipt 1.0.0

Jednoduchy konzolovy program pro vytvareni uctenek.

## Autori
- DOPLNTE JMENO 1
- DOPLNTE JMENO 2
- DOPLNTE JMENO 3
- DOPLNTE JMENO 4

## Pozadavky
- Java 17 nebo novejsi
- Maven 3.8 nebo novejsi

## Spusteni v IntelliJ IDEA
Otevřete projekt jako Maven projekt a spusťte `cz.easyreceipt.Main`.

## Testy
```bash
mvn test
```

## Sestaveni spustitelneho JAR
```bash
mvn clean package
```

Po sestaveni spustte z korenove slozky projektu:
```bash
java -jar target/easy-receipt-1.0.0.jar
```

Soubor `store.properties` musi byt ve stejne slozce, ze ktere program spoustite.

## Pouziti
Zadavejte nazev produktu, cenu za kus a pocet kusu. Pro ukonceni zadavani produktu napiste `konec`.
Cena muze pouzivat tecku nebo carku jako desetinný oddelovac.

## Vytvoreni nove verze
1. Zmente verzi v `pom.xml` (napr. `1.0.0` na `1.1.0`).
2. Spustte `mvn test`.
3. Spustte `mvn clean package`.
4. Vytvorte commit a git tag, napr. `v1.1.0`.

Verzovani pouziva format MAJOR.MINOR.PATCH:
- MAJOR: nekompatibilni zmeny,
- MINOR: nove funkce zpetne kompatibilni,
- PATCH: opravy chyb.

## Prispivani pres Git
Kazdy clen tymu by mel vytvorit vlastni vetev, provest smysluplnou zmenu a otevrit Pull Request. Neprovadejte vsechny zmeny pod jednim uctem.
