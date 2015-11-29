# fursplugin
Plugin do FURS za dav�ne blagajne

Paket vsebuje dve implementaciji:
  JSON impmlementacijo, kjer deluje:
    prijava prostora
    izvaja ra�una za zavezance za DDV
    izdaja ra�una za ne zavezance za DDV
  �e ne deluje
    preverjanje podpisa odgovora od FURS
    prijava premi�ne blagajne
    izdaja ra�una iz vezane knjige
    nekatera manj pogosto uporabljena polja v TaxesPerSeller
  
  SOAP implementacija ima te�ave s podpisovanjem zato niti nisem dokon�aval izdaje ra�una
  
Primeru uporabe so v testnih vzorcih. Pred tem si naredi java keystore z vsemi certifikati iz keys mape in s privatnim klju�em, ki si ga dobil
od FURS in ga pod imenom keystore.jks in z geslom changeiz shrani na mapo keys

Upam, da ti bo implementacija pomagala. �e �eli� pospe�iti implementacijo kak�ne manjkajo�e funkcionalnosti ali pomo� pri uporabi se obrni na razvijalca.
    
