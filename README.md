# Project-cafemanagementsystemgroup-17

group's member
| ID            | Name              |  Github account                          |
| :------------ | :-------------    | :-----------                             |
|6531503002     | Korawich Thisarg  | https://github.com/Korawich22            |
|6531503055     | Poonyawat Khomlek | https://github.com/poonyawat0931         |
|6531503085     | Sutapat Chucham   | https://github.com/531503085Sutapat                                        |
|6531503093     | Osathi Jantrasri  | https://github.com/Osathi                |
|6531503122     | Waranchaya Chairin| https://github.com/Waranchaya-Chairin                                         |

# Link to Project on google cloud

Customer url: https://project-cafe-17-mzwduxknra-uc.a.run.app/user

Customer QR code:

<p align="center">
  <img src="src\main\resources\static\images\QRuser.png" width="500" title="hover text">
</p>


Staff url: https://project-cafe-17-mzwduxknra-uc.a.run.app/admin

Staff QR code:

<p align="center">
  <img src="src\main\resources\static\images\QRAdmin.png" width="500" title="hover text">
</p>


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
# 5.search function
```
บริเวณด้านบนของหน้า customer / staff มีแถบค้นหา สามารถพิมพ์สิ่งที่ต้องการค้นห้าแล้วกด search ได้
```
