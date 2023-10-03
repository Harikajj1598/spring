import { useState } from "react";
import { axios } from "react"; 
import { useNavigate} from "react-router-dom";
const MerchantSignUp = () =>{
let navigate = useNavigate()
 let [name,setname] = useState("")
let [email,setemail] = useState("")
let [phone,setPhone] = useState("")
let [gst, setgst] = useState("")
let [password,setPassword] = useState("")
let data = {name,email,phone,gst,password}
let handlesubmit = (e) =>{
e.preventDefault()
axios.post('http://localhost:8080/merchant',data)
.then((res)=>{
    alert('Registered Successfully')
    console.log(res);
    navigate('/')
})

.catch((err)=>{
    alert('Invail Data')
    console.log(err);

})


}
return(

<div className="merchantsignup">
<form >
<fieldset>
                    <legend>Merchant Sign Up</legend>
                    <label>Name:</label>
                    <input value={name} onChange={(e)=>{setName(e.target.value)}} type="text"></input>
                    <label>Phone:</label>
                    <input  value={phone} onChange={(e)=>{setPhone(e.target.value)}} pattern="[0-9]{10}" type="tel"></input>
                    <label>Email:</label>
                    <input value={email} onChange={(e)=>{setEmail(e.target.value)}} type="email"></input>
                    <label>GST:</label>
                    <input value={gst} onChange={(e)=>{setGst(e.target.value)}} type="text"></input>
                    <label>Password:</label>
                    <input value={password} onChange={(e)=>{setPassword(e.target.value)}} type="password"></input>
                    <button onClick={handlesubmit} >Register</button>
                </fieldset>

</form>
</div>

)

}
export default MerchantSignUp