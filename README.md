# MushroomAtlas

Console app in Java — a small mushroom atlas you can search, filter and extend.

## What is this

MushroomAtlas is a project I build while going through the JavaStart course (Java basics, part 1). The idea was simple: a mushroom atlas is a natural fit for the things the course teaches — enums (edibility, hymenophore type), classes with validation, collections, streams, `Optional`, exceptions and file operations.

You start the app, see a menu, and can look up a mushroom by name, browse the whole atlas, filter it, or add and remove entries. Everything you add is saved to a file and loaded again on the next start.

My design notes and a list of course topics already used in the code are in `docs/`.

## App preview

**Main menu**

<img src="screenshots/menu.png" width="500"/>

**Adding a new mushroom**

<img src="screenshots/add-mushroom.png" width="800"/>

**All mushrooms in alphabetical order**

<img src="screenshots/all-mushrooms.png" width="800"/>

## Features

- Search for a mushroom by name (min. 3 characters)
- Show all mushrooms in alphabetical order
- Filter mushrooms by edibility (edible, inedible, poisonous) or by hymenophore type (tubes, gills, teeth, none)
- Add a new mushroom with name, description, edibility and hymenophore type
- Remove a mushroom from the atlas
- Input validation — wrong menu options and invalid data don't crash the app
- Data saved to a file — survives app restarts

## Tech

Java 17, Maven,
Collections (`TreeSet`, `List`) and Streams,
Enums with static factory methods returning `Optional`,
Custom checked and unchecked exceptions,
Object serialization (`ObjectOutputStream` / `ObjectInputStream`),
Date and time API (`LocalDateTime`, `DateTimeFormatter`).

## How to run

You need Java 17 or newer. Maven doesn't have to be installed — the repo includes the Maven Wrapper (`mvnw`), which downloads the right Maven version on first use.

```bash
git clone https://github.com/KrzysiekPorwol/MushroomAtlas.git
cd MushroomAtlas
./mvnw compile
java -cp target/classes io.github.krzysiekporwol.mushroomatlas.App
```

On Windows use `mvnw.cmd compile` instead of `./mvnw compile`.

You can also open the project in IntelliJ IDEA (it's recognized as a Maven project) and run the `App` class.

---

# MushroomAtlas (PL)

Konsolowa aplikacja w Javie — mały atlas grzybów, który można przeszukiwać, filtrować i rozbudowywać.

## O co chodzi

MushroomAtlas to projekt, który piszę w trakcie kursu JavaStart (Java podstawy, część 1). Pomysł był prosty: atlas grzybów naturalnie pasuje do tego, czego uczy kurs — enumy (jadalność, rodzaj hymenoforu), klasy z walidacją, kolekcje, strumienie, `Optional`, wyjątki i operacje na plikach.

Uruchamiasz aplikację, widzisz menu i możesz wyszukać grzyba po nazwie, przejrzeć cały atlas, przefiltrować go albo dodawać i usuwać grzyby. Wszystko, co dodasz, zapisuje się do pliku i wczytuje przy kolejnym uruchomieniu.

Moje notatki projektowe i lista zagadnień z kursu wykorzystanych w kodzie są w `docs/`.

## Prezentacja aplikacji

**Menu główne**

<img src="screenshots/menu.png" width="500"/>

**Dodawanie nowego grzyba**

<img src="screenshots/add-mushroom.png" width="800"/>

**Wszystkie grzyby alfabetycznie**

<img src="screenshots/all-mushrooms.png" width="800"/>

## Co robi aplikacja

- Wyszukiwanie grzyba po nazwie (min. 3 znaki)
- Wyświetlanie wszystkich grzybów alfabetycznie
- Filtrowanie po jadalności (jadalny, niejadalny, trujący) albo po rodzaju hymenoforu (rurkowy, blaszkowy, kolczasty, brak)
- Dodawanie nowego grzyba — nazwa, opis, jadalność i rodzaj hymenoforu
- Usuwanie grzyba z atlasu
- Walidacja danych — błędna opcja w menu czy złe dane nie wywalają aplikacji
- Dane zapisywane do pliku — przeżywają zamknięcie aplikacji

## Technologie

Java 17, Maven,
Kolekcje (`TreeSet`, `List`) i strumienie,
Enumy ze statycznymi metodami fabrykującymi zwracającymi `Optional`,
Własne wyjątki checked i unchecked,
Serializacja obiektów (`ObjectOutputStream` / `ObjectInputStream`),
Daty i czas (`LocalDateTime`, `DateTimeFormatter`).

## Uruchomienie

Potrzebujesz Javy 17 lub nowszej. Mavena nie trzeba instalować — repo zawiera Maven Wrapper (`mvnw`), który przy pierwszym uruchomieniu sam pobiera odpowiednią wersję Mavena.

```bash
git clone https://github.com/KrzysiekPorwol/MushroomAtlas.git
cd MushroomAtlas
./mvnw compile
java -cp target/classes io.github.krzysiekporwol.mushroomatlas.App
```

Na Windowsie zamiast `./mvnw compile` użyj `mvnw.cmd compile`.

Możesz też otworzyć projekt w IntelliJ IDEA (zostanie rozpoznany jako projekt Mavena) i uruchomić klasę `App`.
