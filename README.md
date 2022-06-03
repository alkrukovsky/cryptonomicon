# cryptonomicon



## Описание

Cryptonomicon - утилита, позволяющая узнать точный курс криптовалют. 
Посредством выбора целевой криптовалюты и списка криптовалют пользователю получает курс обмена по каждой из последних. 

## Запуск программы

Программа запускается из коммандной строки с предоставление входных параметров:

java -jar cryptonomicon.jar [OPTIONS] <targetCurrencyCode> <currecyCodes>

Где [OPTIONS] - необязательные опции для доп. команд приложения:

   --help - выводит на экран справку по программе, опции, и как запускать.
   --list - список целевых поддерживаемых программой кодов криптовалют с описанием

При этом:
<targetCurrencyCode> - код целевой криптовалювалюты  
<currecyCodes> - список кодов криптовалют, которые подлежат обмену на целевую

## Результаты выполнения программы

```
> cryptonomicon USD 611 ABC ACP ACT ADCN AE AGI AIB
target: USD,
rates: 
    "611": 0.389165,
    "ABC": 59.99,
    "ACP": 0.014931,
    "ACT": 0.15927,
    "ADCN": 0.001406,
    "AE": 2.551479,
    "AGI": 0.12555,
    "AIB": 0.005626
 ```   

```
> cryptonomicon --list
"AED": "United Arab Emirates Dirham",
"AFN": "Afghan Afghani",
"ALL": "Albanian Lek",
"AMD": "Armenian Dram",
"ANG": "Netherlands Antillean Guilder",
"AOA": "Angolan Kwanza",
...
 ```   

 ```
> cryptonomicon --help
USAGE java -jar cryptonomicon.jar [OPTIONS] <targetCurrencyCode> <currecyCodes>

<targetCurrencyCode> - target currency code
<currecyCodes> - the list of currency codes tp display exchange rate

where [OPTIONS] - optionals for specials commands:

   --help - dispay help
   --list - the list of available cryptocurrencies

 ```   

## Working with git

Clone remote git repository
```
git clone https://gitlab.com/cncrg-starters/cryptonomicon.git cryptonomicon
```

commit to remote repository
```
git add .
git commit -m "<MESSAGE FOR COMMIT>"
git push
```

connect already existed local repository with remote
```
cd existing_repo
git remote add origin https://gitlab.com/cncrg-starters/cryptonomicon.git
git push -uf origin master
```

## Хранение данных

На первом этапе все данные будем хранить в CSV файлах по следующим правилам:
1. Название файла соотвествует коду целевой валюты
2. Содержимое файла содержит таблицу курсов во все поддерживаемые системой валюты
в таком виде
```
AOA,Angolan Kwanza
611,0.389165
ABC,59.99
ACP,0.014931
ACT,0.15927
ADCN,0.001406
```
<b>При этом важно учитывать, что самая первая строчка - это описание целевой валюты</b>
    
## Архитектура программы

![Architecture](docs/architecture.png)

## Диаграмма исполнения

![Sequence Diagram](docs/bLAxRiCm3Dpr5HnZeFw1e0XIk4E7JkbOT51irYPWFK1H3VptfMsqIEeCgYQ1kkCze6CIovBTQCn07GAwA1CuT6VaP8nj9J3aX6nCpo57I4Eu05l1PEOnr0TeU8eIV73K1hy7PydlAhYG3D1cPlGjAVe6TOSsBpxDUtVL5hiyd326H6fesiCd-Mv5lmcJxq5Z.png)

