
val dataUsers = mutableMapOf<String,String>()


fun main() {

    while (true){

        try {

            when(menu()){

                1->addUser()
                2->checkUser()
                3->removeUser()
                0->break

            }

        }catch (e:Exception){
            println("مقدار نامعتبر وارد شده است !")
            println(e.message)
        }




    }

}

fun menu():Int{

    println("[1]   اضافه کردن مخاطب ")
    println("[2] استعلام شماره مخاطب ")
    println("[3]   حذف اطلاعات مخاطب ")
    println("[0]     خروج از برنامه ")
    println("=======================")
    val request = readLine()?.toInt()!!
    return request
}

fun addUser() {
    println("نام مخاطب را وارد نمایید")
    var userName = readLine()!!
    println("شماره مخاطب را وارد نمایید")
    var phoneNumber = readLine()!!
    var checking = dataUsers.filter { it.value == phoneNumber }
    if (checking.isNotEmpty())
        return println("کاربری با این شماره قبلا ثبت گردیده است !")
    dataUsers[userName]=phoneNumber
    println("اطلاعات کاربر با موفقیت ثبت شد ")
}

fun checkUser(){
    println("نام مخاطب را وارد نمایید")
    var name = readLine()!!
    if (dataUsers.containsKey(name)) {
        val value = dataUsers[name]
        println("شماره $name برابر  است با : $value")
    } else {
        println("نام وارد شده در لیست وجود ندارد.")
    }
}

fun removeUser(){
    println("نام مخاطب را وارد نمایید")
    var name = readLine()!!
    if (dataUsers.containsKey(name)) {
        dataUsers.remove(name)
        println("کاربر با موفقیت حذف گردید")
        return
    } else {
        println("نام وارد شده در لیست وجود ندارد.")
    }

}



