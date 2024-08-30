import React,{useState} from "react"
export default function LoginPage(){
    const [inputs,setInputs] = useState({username:"",password:""});
    const handleOnChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setInputs({...inputs,[name]:value});
    }
    const handleSubmit = (event)=>{
        event.preventDefault();
        console.log(inputs);
    }
    return(
        <div>
            <form onSubmit={handleSubmit}>
                <label>username</label>
                <input type="text" name="username" value={inputs.username} onChange={handleOnChange}></input>
                <label>password</label>
                <input type="password" name="password" value={inputs.password} onChange={handleOnChange}></input>
                <input type="submit"/>
            </form>
        </div>
    )
}