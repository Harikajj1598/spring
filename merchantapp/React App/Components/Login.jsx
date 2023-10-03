Login.jsx
import axios from 'axios'
import { useState } from "react"

const Login=()=>{
    let [phone,setPhone]=useState("")
    let [password,setPassword]=useState("")
    let Login=(e)=>{
        e.preventDefault()
        axios.post(http://localhost:8080/merchant/verify-by-phone?phone=${phone}&password=${password})
        .then((response)=>{
            alert(response.data.message)
        })
        .catch(()=>{
            alert("invalid credentials")
        })
    }
    return(
        <div>
            <form>
                <input type="tel" value={phone} onChange={(e=>{setPhone(e.target.value)})} placeholder="enter your phone number"></input><br></br><br></br>
                <input type="password" value={password} onChange={(e=>{setPassword(e.target.value)})} placeholder="enter your password"></input><br></br><br></br>
                <button onClick={Login}>Login</button>
            </form>
        </div>
    )
}
export default Login