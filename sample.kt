import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.util.*
import java.util.Arrays.toString
import java.util.stream.Collectors
import kotlin.reflect.KVisibility
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.typeOf


class SomeAPICont{
    val `1`: SomeNestedObjects = SomeNestedObjects()
    val `2`: SomeNestedObjects = SomeNestedObjects()
    val `3`: SomeNestedObjects = SomeNestedObjects()
    val `4`: SomeNestedObjects = SomeNestedObjects()
    val `5`: SomeNestedObjects = SomeNestedObjects()
    val `6`: SomeNestedObjects = SomeNestedObjects()
    val `7`: SomeNestedObjects = SomeNestedObjects()
    val `8`: SomeNestedObjects = SomeNestedObjects()
    val `9`: SomeNestedObjects = SomeNestedObjects()
    val `10`: SomeNestedObjects = SomeNestedObjects()
    val `11`: SomeNestedObjects = SomeNestedObjects()
    val `12`: SomeNestedObjects = SomeNestedObjects()
    val `13`: SomeNestedObjects = SomeNestedObjects()
    val `14`: SomeNestedObjects = SomeNestedObjects()
    val `15`: SomeNestedObjects = SomeNestedObjects()
    val `16`: SomeNestedObjects = SomeNestedObjects()
    val `17`: SomeNestedObjects = SomeNestedObjects()
    val `18`: SomeNestedObjects = SomeNestedObjects()
    val `19`: SomeNestedObjects = SomeNestedObjects()
    val `20`: SomeNestedObjects = SomeNestedObjects()
    val `21`: SomeNestedObjects = SomeNestedObjects()
    val `22`: SomeNestedObjects = SomeNestedObjects()
    val `23`: SomeNestedObjects = SomeNestedObjects()
    val `24`: SomeNestedObjects = SomeNestedObjects()
    val `25`: SomeNestedObjects = SomeNestedObjects()
    val `26`: SomeNestedObjects = SomeNestedObjects()
    val `27`: SomeNestedObjects = SomeNestedObjects()
    val `28`: SomeNestedObjects = SomeNestedObjects()
    val `29`: SomeNestedObjects = SomeNestedObjects()
    val `30`: SomeNestedObjects = SomeNestedObjects()
    val `31`: SomeNestedObjects = SomeNestedObjects()
    val `32`: SomeNestedObjects = SomeNestedObjects()
    val `33`: SomeNestedObjects = SomeNestedObjects()
    val `34`: SomeNestedObjects = SomeNestedObjects()
    val `35`: SomeNestedObjects = SomeNestedObjects()
    val `36`: SomeNestedObjects = SomeNestedObjects()
    val num: Int = 3
}

class SomeNestedObjects {
    val info: Long = 4L
}

fun main() {
    val someResponse = SomeAPICont()
//    println(someResponse.`1`.info)


    //Kotlin Method:
    var i=0
    lateinit var theclass:Any
    someResponse::class.memberProperties.forEach{
//        it.isAccessible = true
        if (it.visibility == KVisibility.PUBLIC) {
            if (i++ == 0) theclass = it.getter.call(someResponse)!!
            var tclass = theclass
            theclass::class.declaredMemberProperties.forEach{
                //it.isAccessible = true
                if (it.visibility == KVisibility.PUBLIC) {
                    println("NAME:" + it.name)
                    println(it.getter.call(tclass))
                }
            }
        }
    }

    var nestedResponse = someResponse.`1`
    var field1 = nestedResponse.javaClass.getDeclaredField("info")
    field1.trySetAccessible()

    println(field1.getLong(nestedResponse))


    var dataClass = someResponse.javaClass.declaredFields
    dataClass.forEach { parentField ->
        /*val type = parentField.type
        val typeField = type.javaClass.declaredFields
        type.declaredFields.forEach{
            println(it.name)
            val type = it.type*/
        //parentField.trySetAccessible()
        /*parentField.trySetAccessible()*/
        var type = parentField.type
        /*type::class.memberProperties.forEach{
            if (it.visibility == KVisibility.PUBLIC){
                println("name:" + it.name)
            }
        }*/

        ////i got it
        parentField.trySetAccessible()


        val theclass2 = parentField.get(someResponse)
        //println(theclass2)
        var theClass3 = parentField.get(someResponse)
        i=0
        parentField.javaClass.declaredFields.forEach{
            if (i++==0)theClass3 = it.get(someResponse)
        }
        println(theClass3)

        /*var classtype = parentField.get(type.javaClass.)*/
        type.declaredFields.forEach { subField ->
            subField.trySetAccessible()
            println(subField.name)
            println(theclass is SomeNestedObjects)
            println(theclass2 is SomeNestedObjects)
            println(theClass3 is SomeNestedObjects)
            println("HERE IT IS: (1) " + subField.getLong(theclass).toString())
            println("HERE IT IS: (2) " + subField.getLong(theclass2).toString())
            println("HERE IT IS: (3) " + subField.getLong(theClass3).toString())
            //println("HERE IT IS: " + subField.getLong(SomeNestedObjects()).toString())
        }

    }
//    someResponse::class.memberProperties.forEach {
//        if (it.visibility == KVisibility.PUBLIC) {
//            println(it.name)
//            println(it.getter.call(someResponse))
//        }
//    }
    /*someResponse::class.declaredMemberProperties.forEach {
        println(it.name)
        val data = it.getter.call(someResponse)

    }*/
}




/*    data.forEach{
        println(it.toString())
    }

    var data2 = someResponse.javaClass.classes
    println(data2.size)
    data2.forEach{
        println(it.getDeclaredField("info"))
    }

    someResponse.javaClass.declaredFields.forEachIndexed{i, field ->
        critArray[i] = field.name.toLong()
        var fieldClass = field.javaClass.classes
        var data = fieldClass.javaClass.declaredFields
        println(Arrays.toString(data))
    }

    println(Arrays.toString(critArray))*/

