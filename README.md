# du1

## Funkce programu
Program má dvě základní funkce. Nejprve výpočet a výpis souřadnic rovnoběžek a poledníků na základě zvoleného válcového tečného zobrazení,
poloměru Země a měřítka. Následně pak výpočet a výpis souřadnic bodů vybraných na základě zadané zeměpisné šířky a zeměpisné délky
se stejnými zadanými parametry.

## Zadávané parametry
Program je interaktivní a je možné upravovat parametry výpočtu. Volenými parametry jsou: zobrazení, měřítko a poloměr Země.

### Zobrazení
Lze vybírat z následujících válcových tečných zobrazení:
- Marinovo (A, písmeno pro volbu v programu) - x = r * arc λ; y = r * arc φ
- Lambertovo (L) - x = r * arc λ; y = r * sin φ
- Braunovo (B) - x = r * arc λ; y = 2r * tg(φ/2)
- Mercatorovo (M) - x = r * arc λ; y = r * ln(cotg(δ/2))
- Wetchovo (W) - x = r * arc λ; y = r * tgφ
Jako parametr 'z' je možné zadat pouze písmeno odpovídající jednomu z pěti výše zmíněných zobrazení. V jiném případě program skončí.

### Měřítko
Dalším voleným parametrem je měřítko 'm'. To je možné zadávat v intervalu (0,∞). V jiném případě program skončí.

### Poloměr Země
Posledním voleným parametrem je poloměr Země 'r'. Ten je možné vybírat v intrevalu <0,∞), přičemž při výběru 0 je automaticky nastaven
poloměr Země na 6371.11 km. Parametr 'r' je zadáván v kilometrech. V jiném případě program skončí.

Následně program vypíše souřadnice rovnoběžek a poledníků. Tyto souřadnice jsou vypsány v centimetrech se zaorouhlením na milimetry.

Poté je uživatel dotázán na zeměpisnou šířku a zeměpisnou délku, podle které se vypočtou souřadnice tohoto vybraného bodu. Suřadnice jsou
opět napsány v centimetrech se zaokrouhlením na milimetry.

Program je ukončen zadáním (0,0), tedy 0 u zeměpisné šířky a 0 u zeměpisné délky.
