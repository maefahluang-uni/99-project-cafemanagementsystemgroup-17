# Project-cafemanagementsystemgroup-17


```
group's member's

6531503002 Korawich Thisarg. 

6531503055 Poonyawat Khomlek.

6531503085 Sutapat Chucham.

6531503093 Osathi Jantrasri.

```

# 1.customer/staff ระบบสั่งอาหาร
```
1.customer เข้าไปที่หน้า /user 
    -สั่งอาหารโดยการกด select เลือกจำนวนอาหารและรายละเอียดที่ต้องการแล้วกด add to card

2.customer กดไปที่ไอค่อนรถเข็นบริเวณมุมขวาบน 
    - สามารถ delete order ที่สั่งได้
    - เขียน note ให้ staff 
    - เลือกโต๊ะที่นั่ง
    - กดปุ่ม confirm

3.staff เข้าไปที่ /admin
    - username: "admin" pass: "1234"
    - ไปที่แถบ InvoiceItem List
    - กด confirm order ที่ลูกค้าสั่งมา (จะมีการคำนวนราคาและแสดงใน payment list, และบริเวณ /admin หน้าแรก)

4.customer รีเฟรชหน้าร้านค้า เพื่อดูสถาณะของ order ได้ที่ confirm/cancel receipt บริเวณด้านล่าง


```
# 2.staff - add/update/delete dish
```
1.staff เข้าไปที่ /admin
    - username: "admin" pass: "1234"
    - ไปที่แถบ Menu List

2.add dish
    - กดปุ่ม Add new dishes 
    - กรอกข้อมูลแล้วกด confirm

3.update dish
    - กดปุ่ม update หลัง dishes ที่ต้องการแก้ไข
    - กรอกข้อมูลและกด confirm

4.delete dish 
    - กดปุ่ม delete หลัง dishes ที่ต้องการลบ
    - ไม่สามารถลบได้หากเป็นรายการอาหารที่มีข้อมูลอยู่ใน invoiceitem เพราะติด fk constrain
```
# 3.staff - add/update/delete material
```
1.staff เข้าไปที่ /admin
    - username: "admin" pass: "1234"
    - ไปที่แถบ Material List

2.add material
    - กดปุ่ม Add new material
    - กรอกข้อมูลแล้วกด confirm

3.update material
    - กดปุ่ม update หลัง material ที่ต้องการแก้ไข
    - กรอกข้อมูลและกด confirm

4.delete material
    - กดปุ่ม delete หลัง material ที่ต้องการลบ
    - ไม่สามารถลบได้หากเป็นรายการที่มีข้อมูลอยู่ใน Expense List เพราะติด fk constrain
```
# 4.staff - use material
```
1.staff เข้าไปที่ /admin
    - username: "admin" pass: "1234"
    - ไปที่แถบ Menu List

2.use material
    - เลือกจำนวนที่ต้องการใช้ และกดปุ่ม use material หลัง material ที่ต้องการใช้
    - จะมีสรุปรายจ่ายในแถบ Expense, และบริเวณ /admin หน้าแรก
```

URL:https://lab-cd-hgkayqprna-uc.a.run.app/

UserQR
![Alt text](https://cdn.discordapp.com/attachments/1094640869396717608/1176808442938273822/CafeUser_2.png?ex%253D65703744%2526is%253D655dc244%2526hm%253Df6e9786cdf0af71e615047ee48b93e139bb582b1fd537d98c53b02e9ad343f9f%2526)

AdminQR
![Alt text](https://cdn.discordapp.com/attachments/1094640869396717608/1176816756447248384/CafeAdmin.png?ex%253D65703f02%2526is%253D655dca02%2526hm%253D3de3517aaa01fb323b901240c8138b867c5fbf76c1704c49d9692c6746343419%2526)