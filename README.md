# fursplugin
Plugin do FURS za davène blagajne

Paket vsebuje dve implementaciji:
  JSON impmlementacijo, kjer deluje:
    prijava prostora
    izvaja raèuna za zavezance za DDV
    izdaja raèuna za ne zavezance za DDV
  še ne deluje
    preverjanje podpisa odgovora od FURS
    prijava premiène blagajne
    izdaja raèuna iz vezane knjige
    nekatera manj pogosto uporabljena polja v TaxesPerSeller
  
  SOAP implementacija ima težave s podpisovanjem zato niti nisem dokonèaval izdaje raèuna
  
Primeru uporabe so v testnih vzorcih. Pred tem si naredi java keystore z vsemi certifikati iz keys mape in s privatnim kljuèem, ki si ga dobil
od FURS in ga pod imenom keystore.jks in z geslom changeiz shrani na mapo keys

Upam, da ti bo implementacija pomagala. Èe želiš pospešiti implementacijo kakšne manjkajoèe funkcionalnosti ali pomoè pri uporabi se obrni na razvijalca.
    
