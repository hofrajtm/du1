# du1
## Funkce programu

Program má dvě základní funkce. Nejprve výpočet a výpis souřadnic rovnoběžek a poledníků na základě zvoleného válcového tečného zobrazení,
poloměru Země a měřítka. Následně pak výpočet a výpis souřadnic bodů vybraných na základě zadané zeměpisné šířky a zeměpisné délky
se stejnými zadanými parametry.

## Zadávané parametry

Program je interaktivní a je možné upravovat parametry výpočtu. Volenými parametry jsou: zobrazení, poloměr Země a měřítko.
1. Zobrazení, ze kterých lze vybírat, jsou následující:
- Marinovo (A, písmeno pro volbu v programu) - x = r * arc λ; y = r * arc φ
- Lambertovo (L) - x = r * arc λ; y = r * sin φ
- Braunovo (B) - x = r * arc λ; y = 2r * tg(φ/2)
- Mercatorovo (M) - x = r * arc λ; y = r * ln(cotg(δ/2))
- Wetchovo (W) - x = r * arc λ; y = r * tgφ

