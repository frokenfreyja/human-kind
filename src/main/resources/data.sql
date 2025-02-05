/*Data about user that are organization*/
INSERT INTO users
    (name, bio, email, password, image_name, is_enabled, orgi, phone)
VALUES
    ('Rauði Krossinn',
     'Rauði krossinn á Íslandi er hluti af stærstu mannúðar- og hjálparsamtökum heims. Allt starf Rauða Krossins miðar að því að bregðast við og aðstoða þar sem neyðin er mest.',
     'central@redcross.is',
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'Raudikrossinn_png.png',
     true,
     true,
     '5704000'
    ),
    ('Dýrahjálp',
     'Markmið félagsins er að leitast við að sjá dýrum sem þarfnast heimilis fyrir skjóli og stofna til þess dýraathvarf og að vinna almenning í landinu til fylgis og stuðnings við dýravernd. Mun dýraathvarfið taka við öllum dýrum sem þarfnast nýs heimilis og reyna að finna þeim nýtt heimili. Þangað til hægt verði að stofna til slíks athvarfs mun félagið leitast við að finna þeim dýrum sem annars væri lógað ný heimili, hvort sem það er fósturheimili eða varanlegt heimili.',
     'dyrahjalp@dyrahjalp.is',
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'dýrahjálp.PNG',
     true,
     true,
     '5304800'
    ),
    ('UNICEF',
     'UNICEF á Íslandi er íslensk landsnefnd Barnahjálpar Sameinuðu þjóðanna. UNICEF er leiðandi í hjálparstarfi fyrir börn í heiminum. Við berjumst fyrir réttindum allra barna og sinnum bæði langtímauppbyggingu og neyðaraðstoð. Við erum á vettvangi í yfir 190 löndum og höfum að leiðarljósi að börn njóti velferðar – hvar sem þau er að finna.',
     'unicef@unicef.is',
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'unicef.jpg',
     true,
     true,
     '5526300'
    ),
    ('Amnesty International',
     'Amnesty Internati­onal er alþjóðleg mann­rétt­inda­hreyfing rúmlega sjö milljóna einstak­linga í meira en 150 löndum. Við berj­umst fyrir heimi þar sem sérhver einstak­lingur nýtur mann­rétt­inda sinna.',
     'amnesty@amnesty.is',
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'amnesty.png',
     true,
     true,
     '5117900'
    ),
    ('Píeta',
     'Píeta samtökin sinna forvarnarstarfi gegn sjálfsvígum og sjálfsskaða og styðja við aðstandendur.
     Samtökin opnuðu þjónustu sína vorið 2018 og eru með starfsemina að Baldursgötu 7 í Reykjavík.  Til samtakanna geta leitað einstaklingar og aðstandendur sem vilja fá hjálp og viðtal hjá fagfólki. Lagt er upp úr því að  bjóða upp á rólegt og notalegt umhverfi  fyrir skjólstæðinga.
     Starfsemin er rekin að fyrirmynd og eftir hugmyndafræði Pieta House á Írlandi.
     Meðferð okkar er mótuð af samúð og virðingu fyrir hverjum þeim sem til okkar leitar og áhersla lögð á lausnir og uppbyggingu. Miðað er að því að leysa yfirstandandi krísu með viðkomandi og glæða von um líf sem er þess virði að lifa. Kennd eru ýmis bjargráð til að fást við erfiðar tilfinningar ásamt streitu- og tilfinningastjórnun og samskiptafærni. Gefinn er kostur á allt að 15 viðtölum, en þörfin er metin í hverju tilviki fyrir sig. Þegar við á er fjölskyldu og/eða nánustu aðstandendum boðið að taka þátt í meðferðinni, með það að markmiði að styrkja stuðningsnet einstaklingsins. Gefinn er kostur á allt að 5 viðtölum fyrir aðstandendur.',
     'pieta@pieta.is',
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'pieta.png',
     true,
     true,
     '5522218'
    ),
    ('Landvernd',
     'Landvernd eru frjáls félagasamtök sem starfa að umhverfismálum til að vernda og bæta lífsgæðin í landinu. Hlutverk Landverndar er að standa vörð um íslenska náttúru og vera virkur þátttakandi í stefnumótun, fræðslu og upplýstri ákvarðanatöku í málum er varða landnotkun, auðlindir og umhverfi.',
     'landvernd@landvernd.is',
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'landvernd.png',
     true,
     true,
     '5525242'
    ),
    ('Hjálparstarf Kirkjunnar',
     'Hlutverk Hjálparstarfs Kirkjunnar er að hafa forgöngu um og samhæfa mannúðar- og hjálparstarf íslensku þjóðkirkjunnar innanlands sem utan.',
     'help@help.is',
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'help.PNG',
      true,
      true,
      '5284400'
    );


/* Data about users that are volunteers*/
INSERT INTO users
    (name, email, gender, birth_date, password, image_name, is_enabled, orgi, phone)
VALUES
    ('Arnar Steinn Ólafsson',
     'aso40@hi.is' ,
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '20190928_140000.jpg',
     true,
     false,
     '8676718'
     ),
     ('Freyja Sigurgísladóttir',
     'freyjasigur@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'freyja.jpg',
     true,
     false,
     '7716867'
     ),
     ('Aðalmundur Reynarsson',
     'aðal@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'bas.gif',
     true,
     false,
     '8974856'
     ),
     ('Anna Erpardóttir',
     'anna@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '1.jpg',
     true,
     false,
     '7569985'
     ),
     ('Ástvaldur Pálmason',
     'ast@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'jack.jpg',
     true,
     false,
     '8625548'
     ),
     ('Árný ',
     'arny@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'frida.gif',
     true,
     false,
     '4568856'
     ),
     ('Bergur ',
     'bergur@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '2.jpg',
     true,
     false,
     '8214586'
     ),
     ('Brynhildur',
     'brynhildur@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '3.jpg',
     true,
     false,
     '8651234'
     ),
     ('Drengur',
     'drengur@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '4.jpg',
     true,
     false,
     '8975462'
     ),
     ('Dagný',
     'dagny@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '7.jpg',
     true,
     false,
     '7548978'
     ),
     ('Elís',
     'elis@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '5.jpg',
     true,
     false,
     '7988563'
     ),
     ('Ether',
     'ether@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '12.jpg',
     true,
     false,
     '8452648'
     ),
     ('Friður',
     'friður@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '6.jpg',
     true,
     false,
     '8975689'
     ),
     ('Friðmey',
     'fridmey@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '11.jpg',
     true,
     false,
     '8745869'
     ),
     ('Gellir',
     'gellir@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '10.jpg',
     true,
     false,
     '8975545'
     ),
     ('Guðveig',
     'gudveig@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '14.jpg',
     true,
     false,
     '8554726'
     ),
     ('Haraldur',
     'haraldur@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '9.jpg',
     true,
     false,
     '7754866'
     ),
     ('Hjálmdís',
     'hjalmdis@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '19.jpg',
     true,
     false,
     '7125468'
     ),
     ('Indriði',
     'indridi@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '8.jpg',
     true,
     false,
     '7689785'
     ),
     ('Ingirós',
     'ingiros@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '24.jpg',
     true,
     false,
     '7566897'
     ),
     ('Ívar',
     'ivar@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '13.jpg',
     true,
     false,
     '7325589'
     ),
     ('Ísey',
     'isey@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '25.jpg',
     true,
     false,
     '8554789'
     ),
     ('Jóakim',
     'joakim@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '15.jpg',
     true,
     false,
     '8996542'
     ),
     ('Júlía',
     'julia@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '28.jpg',
     true,
     false,
     '8774589'
     ),
     ('Kjartan',
     'kjartan@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '16.jpg',
     true,
     false,
     '8664257'
     ),
     ('Koldís',
     'koldís@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '29.jpg',
     true,
     false,
     '8445698'
     ),
     ('Línberg',
     'linberg@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '17.jpg',
     true,
     false,
     '8995221'
     ),
     ('Lísandra',
     'lisandra@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '32.jpg',
     true,
     false,
     '7114587'
     ),
     ('Melkólmur',
     'melkolmur@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '18.jpg',
     true,
     false,
     '7556528'
     ),
     ('Melkorka',
     'melkorka@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '33.jpg',
     true,
     false,
     '7445812'
     ),
     ('Njáll',
     'njall@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '20.jpg',
     true,
     false,
     '7123456'
     ),
     ('Nóra',
     'nora@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     'amrita-gurney.jpg',
     true,
     false,
     '7875468'
     ),
     ('Ottó',
     'otto@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '21.jpg',
     true,
     false,
     '8997541'
     ),
     ('Oddlaug',
     'oddlaug@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '41.jpg',
     true,
     false,
     '7774285'
     ),
     ('Ómar',
     'omar@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '22.jpg',
     true,
     false,
     '7556482'
     ),
     ('Ólöf',
     'olof@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '42.jpg',
     true,
     false,
     '4865782'
     ),
     ('Páll',
     'pall@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '23.jpg',
     true,
     false,
     '6548952'
     ),
     ('Petra',
     'petra@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '43.jpg',
     true,
     false,
     '6598522'
     ),
     ('Rósi',
     'rosi@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '26.jpg',
     true,
     false,
     '8755548'
     ),
     ('Rúnhildur',
     'runhildur@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '44.jpg',
     true,
     false,
     '8885532'
     ),
     ('Sigtýr',
     'sigtyr@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '27.jpg',
     true,
     false,
     '7778958'
     ),
     ('Sigurhildur',
     'sigurhildur@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '45.jpg',
     true,
     false,
     '8999999'
     ),
     ('Torfi',
     'torfi@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '30.jpg',
     true,
     false,
     '8775468'
     ),
     ('Tóta',
     'tota@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '46.jpg',
     true,
     false,
     '8774512'
     ),
     ('Uggi',
     'uggi@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '31.jpg',
     true,
     false,
     '8667512'
     ),
     ('Unnur',
     'unnur@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '47.jpg',
     true,
     false,
     '8745612'
     ),
     ('Úlfur',
     'ulfur@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '34.jpg',
     true,
     false,
     '8623544'
     ),
     ('Úlfrún',
     'ulfrun@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '48.jpg',
     true,
     false,
     '8554123'
     ),
     ('Valmar',
     'valmar@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '35.jpg',
     true,
     false,
     '8866542'
     ),
     ('Valgerður',
     'valgerður@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '49.jpg',
     true,
     false,
     '7448562'
     ),
     ('Yngvi',
     'yngvi@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '36.jpg',
     true,
     false,
     '7445868'
     ),
     ('Ylfa',
     'ylfa@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '50.jpg',
     true,
     false,
     '7445626'
     ),
     ('Ýmir',
     'ymir@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '37.jpg',
     true,
     false,
     '7995627'
     ),
     ('Ýr',
     'yr@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '51.jpg',
     true,
     false,
     '7895585'
     ),
     ('Þeyr',
     'teyr@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '38.jpg',
     true,
     false,
     '8556424'
     ),
     ('Þóra',
     'tora@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '52.jpg',
     true,
     false,
     '7441235'
     ),
     ('Ægir',
     'aegir@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '39.jpg',
     true,
     false,
     '7985624'
     ),
     ('Æsgerður',
     'aegerdur@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '53.jpg',
     true,
     false,
     '7998569'
     ),
     ('Ögmundur',
     'ogmundur@gmail.com',
     'Male',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '40.jpg',
     true,
     false,
     '8556256'
     ),
     ('Ölveig',
     'olveig@gmail.com',
     'Female',
     TO_DATE('1995-07-19', 'YYYY-MM-DD'),
     '$2a$10$YRAcO8NcVOLYMv9H0nCDNus4qsM6BaM/TSjm1bSSvsZjzfKIJ4.4K',
     '54.jpg',
     true,
     false,
     '89898989'
     );

/*Data about published ads*/
INSERT INTO ad
    (name, closed, date, description, gen_loc, general_loc, image_name, interest, location, msg, organization, owner, zipcode)
VALUES
    ('Kisupössun',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Höfuðborgarsvæði',
     'Höfuðborgarsvæði',
     'kisa1.jpg',
     'Animals',
     'Reykjavík',
     'þetta er samþykkjunarskilaboð',
     'Dýrahjálp',
     2,
     101
    ),
    ('Hundapössun',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Norðurland',
     'Norðurland',
     'dogs.jpg',
     'Animals',
     'Akureyri',
     'þetta we samþykkjunarskilaboð',
     'Dýrahjálp',
     2,
     531
    ),
    ('Kanínupössun',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Austurland',
     'Austurland',
     'kan.jpg',
     'Animals',
     'Egilstaðir',
     'þetta er samþykkjunarskilaboð',
     'Dýrahjálp',
     2,
     690
    ),
    ('Vinaverkefni',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Vestfirðir',
     'Vestfirðir',
     'vinaverk.jpg',
     'People',
     'Ísafjörður',
     'þetta er samþykkjunarskilaboð',
     'Rauði Krossin',
     1,
     400
    ),
    ('Leiðsögn flóttafólks',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Suðurnes',
     'Suðurnes',
     'flott.jpg',
     'People',
     'Keflavík',
     'þetta er samþykkjunarskilaboð',
     'Rauði Krossin',
     1,
     190
    ),
    ('Námsaðstoð',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Norðurland',
     'Norðurland',
     'nam.jpg',
     'People',
     'Dalvík',
     'þetta er samþykkjunarskilaboð',
     'Rauði Krossin',
     1,
     640
    ),
    ('Styrktarsöfnun',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Austurland',
     'Austurland',
     'styrk.jpg',
     'Other',
     'Húsavík',
     'þetta er samþykkjunarskilaboð',
     'UNICEF',
     3,
     700
    ),
    ('Heimsforeldri',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Suðurnes',
     'Suðurnes',
     'for.jpg',
     'Other',
     'Reykjanesbær',
     'þetta er samþykkjunarskilaboð',
     'UNICEF',
     3,
     233
    ),
    ('Heilsugæsla',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Vesturland',
     'Vesturland',
     'heils.jpg',
     'Other',
     'Ólafsvík',
     'þetta er samþykkjunarskilaboð',
     'UNICEF',
     3,
     360
    ),
    ('Fjármagnasöfnun',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Suðurnes',
     'Suðurnes',
     'fjar.jpg',
     'Other',
     'Vogar',
     'þetta er samþykkjunarskilaboð',
     'Amnesty International',
     4,
     250
    ),
    ('Kortagerð',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Vesturland',
     'Vesturland',
     'kort.jpg',
     'Other',
     'Stykkishólmur',
     'þetta er samþykkjunarskilaboð',
     'Amnesty International',
     4,
     380
    ),
    ('Manréttindafræðsla',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Höfuðborgarsvæðið',
     'Höfuðborgarsvæðið',
     'mann.jpg',
     'Other',
     'Kópavogur',
     'þetta er samþykkjunarskilaboð',
     'Amnesty International',
     4,
     111
    ),
    ('Sjálfboðaliða í uppsetningu',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Höfuðborgarsvæðið',
     'Höfuðborgarsvæðið',
     'sil.png',
     'Other',
     'Garðarbær',
     'þetta er samþykkjunarskilaboð',
     'Píeta',
     5,
     201
    );
    /* eftir að fylla meira
    ,('',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Suðurnes',
     'Suðurnes',
     '',
     '',
     'Keflavík',
     'þetta er samþykkjunarskilaboð',
     'Píeta',
     5,
     233
    ),
    ('',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Suðurland',
     'Suðurland',
     '',
     '',
     'Vík',
     'þetta er samþykkjunarskilaboð',
     'Píeta',
     5,
     800
    ),
    ('',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Suðurland',
     'Suðurland',
     '',
     '',
     'Selfoss',
     'þetta er samþykkjunarskilaboð',
     'Landvernd',
     6,
     851
    ),
    ('',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Austurland',
     'Austurland',
     '',
     '',
     'Neskaupstaður',
     'þetta er samþykkjunarskilaboð',
     'Landvernd',
     6,
     755
    ),
    ('',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Vesturland',
     'Vesturland',
     '',
     '',
     'Grundarfjörður',
     'þetta er samþykkjunarskilaboð',
     'Landvernd',
     6,
     371
    ),
    ('',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Vestfirðir',
     'Vestfirðir',
     '',
     '',
     'Breiðavík',
     'þetta er samþykkjunarskilaboð',
     'Hjálparstraf Kirkjunnar',
     7,
     520
    ),
    ('',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Vesturland',
     'Vesturland',
     '',
     '',
     'Borgarnes',
     'þetta er samþykkjunarskilaboð',
     'Hjálparstraf Kirkjunnar',
     7,
     320
    ),
    ('',
     false,
     TO_DATE('2020-07-19', 'YYYY-MM-DD'),
     'Hér kemur lýsing um starf',
     'Höfuðborgarsvæðið',
     'Höfuðborgarsvæðið',
     '',
     '',
     'Reykjavík',
     'þetta er samþykkjunarskilaboð',
     'Hjálparstraf Kirkjunnar',
     7,
     101
    );*/

/*Data about published ads*/
INSERT INTO applicant
    (accepted, ad, rejected, users)
VALUES
    (false,
    1,
    false,
    8
    ),
    (false,
    1,
    false,
    11
    ),
    (false,
    1,
    false,
    18
    ),
    (false,
    1,
    false,
    20
    ),(false,
    1,
    false,
    54
    ),
    (false,
    1,
    false,
    34
    ),
    (false,
    2,
    false,
    9
    ),
    (false,
    2,
    false,
    66
    ),
    (false,
    2,
    false,
    47
    ),
    (false,
    2,
    false,
    40
    ),
    (false,
    2,
    false,
    39
    ),
    (false,
    2,
    false,
    37
    ),
    (false,
    2,
    false,
    27
    ),
    (false,
    3,
    false,
    22
    ),
    (false,
    3,
    false,
    20
    ),
    (false,
    3,
    false,
    19
    ),
    (false,
    3,
    false,
    16
    ),
    (false,
    3,
    false,
    15
    );




