# fursplugin
Plugin do FURS za davčne blagajne

Paket vsebuje dve implementaciji:
  JSON impmlementacijo, kjer deluje:
    prijava prostora
    izvaja računa za zavezance za DDV
    izdaja računa za ne zavezance za DDV
    spremembe računa
  še ne deluje
    preverjanje podpisa odgovora od FURS
    prijava premične blagajne
    izdaja računa iz vezane knjige
    nekatera manj pogosto uporabljena polja v TaxesPerSeller
  
  SOAP implementacija ima težave s podpisovanjem zato niti nisem dokončal izdaje računa
  
Primeri uporabe so v testnih vzorcih. Pred tem si naredi java certifikatno skladišče keys/keystore.jks:
  z vsemi certifikati iz keys mape 
  in s privatnim ključem (keypair), ki si ga dobilod FURS.
V properties datoteki src/test/resorces/test.properties nastavi:
  issuer.vat na davčno številko, ki si jo dobil v privatnem ključu (v polju OU)
  issuer.signcert.alias na alias, ki si ga nastavil v certifikatnem skladišču za privatni ključ, ki si ga dobil od FURS

Upam, da ti bo implementacija pomagala. če želiš pospešiti implementacijo kakšne manjkajoče funkcionalnosti ali potrebuješ pomoč pri uporabi se obrni na razvijalca.
    
