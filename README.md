# MushroomAtlas

Console app in Java — a small mushroom atlas you can search, filter and extend.

## What is this

MushroomAtlas is a project I'm building to practice Java. The idea was simple: a mushroom atlas is a natural fit for the core language features — enums (edibility, hymenophore type), classes with validation, collections, streams, `Optional` and exceptions. Later I moved the data from a file to a PostgreSQL database, accessed through JDBC.

You start the app, see a menu, and can look up a mushroom by name, browse the whole atlas, filter it, or add and remove entries. Everything is stored in a PostgreSQL database, so the atlas survives app restarts.

My design notes and a list of Java topics used in the code are in `docs/`.

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
- Adding a mushroom that already exists shows a message instead of crashing the app
- Data stored in PostgreSQL — survives app restarts

## Tech

Java 17, Maven,
Collections (`TreeSet`, `List`) and Streams,
Enums with static factory methods returning `Optional`,
PostgreSQL and JDBC (`PreparedStatement`, try-with-resources),
Repository pattern — `MushroomRepository` interface with a JDBC and an in-memory implementation,
Custom unchecked exceptions,
Date and time API (`LocalDateTime`, `DateTimeFormatter`).

## How to run

You need Java 17 or newer and PostgreSQL running on `localhost:5432`. Maven doesn't have to be installed — the repo includes the Maven Wrapper (`mvnw`), which downloads the right Maven version on first use.

**1. Set up the database**

Create a database called `mushroom_atlas` and load the schema (tables and dictionary data) from `db/schema.sql`:

```bash
git clone https://github.com/KrzysiekPorwol/MushroomAtlas.git
cd MushroomAtlas
createdb mushroom_atlas
psql -d mushroom_atlas -f db/schema.sql
```

You can also do this in a GUI client such as DBeaver: create the database, open `db/schema.sql` in its SQL editor and run it as a script.

Connection settings (URL, user, password) are in `DatabaseConnection.java` — change the user to your own PostgreSQL user if needed.

**2. Build and run**

```bash
./mvnw compile
java -cp "target/classes:$(./mvnw -q dependency:build-classpath -Dmdep.outputFile=/dev/stdout)" io.github.krzysiekporwol.mushroomatlas.App
```

The second part of the classpath adds the PostgreSQL JDBC driver, which Maven keeps in its local repository.

The easiest way, also on Windows, is to open the project in IntelliJ IDEA (it's recognized as a Maven project) and run the `App` class — IntelliJ adds the driver to the classpath automatically.

---

# MushroomAtlas (PL)

Konsolowa aplikacja w Javie — mały atlas grzybów, który można przeszukiwać, filtrować i rozbudowywać.

## O co chodzi

MushroomAtlas to projekt, który rozwijam, żeby ćwiczyć Javę. Pomysł był prosty: atlas grzybów naturalnie pasuje do podstawowych elementów języka — enumy (jadalność, rodzaj hymenoforu), klasy z walidacją, kolekcje, strumienie, `Optional` i wyjątki. Później przeniosłem dane z pliku do bazy PostgreSQL, z którą aplikacja łączy się przez JDBC.

Uruchamiasz aplikację, widzisz menu i możesz wyszukać grzyba po nazwie, przejrzeć cały atlas, przefiltrować go albo dodawać i usuwać grzyby. Wszystko trzymane jest w bazie PostgreSQL, więc atlas przeżywa zamknięcie aplikacji.

Moje notatki projektowe i lista zagadnień z Javy wykorzystanych w kodzie są w `docs/`.

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
- Próba dodania grzyba, który już istnieje, kończy się komunikatem, a nie wywaleniem aplikacji
- Dane trzymane w PostgreSQL — przeżywają zamknięcie aplikacji

## Technologie

Java 17, Maven,
Kolekcje (`TreeSet`, `List`) i strumienie,
Enumy ze statycznymi metodami fabrykującymi zwracającymi `Optional`,
PostgreSQL i JDBC (`PreparedStatement`, try-with-resources),
Wzorzec Repository — interfejs `MushroomRepository` z implementacją JDBC i w pamięci,
Własne wyjątki unchecked,
Daty i czas (`LocalDateTime`, `DateTimeFormatter`).

## Uruchomienie

Potrzebujesz Javy 17 lub nowszej i PostgreSQL działającego na `localhost:5432`. Mavena nie trzeba instalować — repo zawiera Maven Wrapper (`mvnw`), który przy pierwszym uruchomieniu sam pobiera odpowiednią wersję Mavena.

**1. Przygotowanie bazy danych**

Utwórz bazę `mushroom_atlas` i wczytaj do niej schemat (tabele i dane słownikowe) z pliku `db/schema.sql`:

```bash
git clone https://github.com/KrzysiekPorwol/MushroomAtlas.git
cd MushroomAtlas
createdb mushroom_atlas
psql -d mushroom_atlas -f db/schema.sql
```

Możesz to też zrobić w kliencie graficznym, np. DBeaverze: utwórz bazę, otwórz `db/schema.sql` w edytorze SQL i uruchom go jako skrypt.

Ustawienia połączenia (URL, użytkownik, hasło) są w `DatabaseConnection.java` — w razie potrzeby zmień użytkownika na swojego użytkownika PostgreSQL.

**2. Kompilacja i uruchomienie**

```bash
./mvnw compile
java -cp "target/classes:$(./mvnw -q dependency:build-classpath -Dmdep.outputFile=/dev/stdout)" io.github.krzysiekporwol.mushroomatlas.App
```

Druga część classpatha dokłada sterownik JDBC PostgreSQL, który Maven trzyma w swoim lokalnym repozytorium.

Najprościej, także na Windowsie, otworzyć projekt w IntelliJ IDEA (zostanie rozpoznany jako projekt Mavena) i uruchomić klasę `App` — IntelliJ sam dołoży sterownik do classpatha.
