# Порождающие паттерны проектирования
Абстрагируют процесс инстанцирования 
объектов. Они позволяют сделать код независимым от способа создания, композиции и 
представления используемых в его работе объектов.
## Singleton (Одиночка)
Гарантирует, что у класса есть только один экземпляр, и предоставляет к нему
глобальную точку доступа.
## Абстрактная фабрика
Предоставляет интерфейс для создания семейств взаимосвязанных или взаимозависимых 
объектов, не специфицируя их конкретных классов.
### Задание
С помощью шаблона Абстрактная фабрика решить следующую задачу:

Обеспечить контроль загрузки и готовности к отправлению автобусов и такси. 
Водитель такси и автобуса имеют права разной категории. Без водителя машина не 
поедет. Два водителя в одну машину сесть не могут. Без пассажиров машины не 
поедут. Есть лимит загрузки машин. Для автобуса 30 чел. Для такси - 4 чел.
Рекомендуется для водителя применить паттерн _синглтон_.

Примерная структура:

![image](https://user-images.githubusercontent.com/107203406/234572768-e8e58466-d9b0-4c45-bdc7-6b18f719e271.png)

### Решение
Диаграмма классов:

![diagram_class](https://user-images.githubusercontent.com/107203406/234578366-145a70d7-472d-4e6a-be5e-3d3962278114.jpg)
