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
  
Primeri uporabe so v testnih vzorcih.
Pred testiranjem si naredi java certifikatno skladišče s strežniškimi certifikati - z vsemi certifikati iz keys mape (strežniški certifikati - javni deli) 
in certifikatno skladišče s privatnim ključem (keypair), ki si ga dobilod FURS. Lahko sta združena v isti datoteki.
V properties datoteki src/test/resorces/test.properties nastavi:
  issuer.vat                     na davčno številko, ki si jo dobil v privatnem ključu (v polju OU)
  issuer.signcert.alias          na alias, ki si ga nastavil v certifikatnem skladišču za privatni ključ, ki si ga dobil od FURS
  truststore.location            na pot do certifikatnega skladišča s privatnim ključem
  truststore.pass                na geslo certifikatnega skladišča s privatnim ključem
  keystore.location              na pot do certifikatnega skladišča s strežniškimi certifikati
  keystore.pass                  na geslo do certifikatnega skladišča s strežniškimi certifikati

Upam, da ti bo implementacija pomagala. če želiš pospešiti implementacijo kakšne manjkajoče funkcionalnosti ali potrebuješ pomoč pri uporabi se obrni na razvijalca.
    
