import { useState } from "react";

function App(){
    //{"id":101,"name":"Vasudha","course":"CSE"}
    const [students,setStudents]=useState([]);
    const [count,setCount]=useState(0);
    const [username,setUsername]= useState("");
    const [password,setPassword]= useState("");

    const getStudentData =async()=>{
        const response=await fetch('http://localhost:8080/student');
        const data= await response.json();
        setStudents(data);
    }
    const fetchTotalStudentCount= async()=>{
        const response= await fetch("https://localhost:8080/student/count");
        const data= await response.json();
        setCount(data);

    };


    const login = async()=> {
        const response =await fetch("http://localhost:8080/auth/login",
            {
                method:"POST",
                hearders:{
                    "Content-Type":
                    "application/json"
                },
                body:JSON.stringify({
                    username,password,
                }),
            }
        );
        alert("Login Successfully");
    };
    return(
        <div>
            <button onClick ={getStudentData}>
                Get Student Data
            </button>
            <h1>This is the student data</h1>
            <ul>
                {students.map(student => (
                    <li key={(student.id)}>
                        {student.course}.{student.name}
                    </li>
                ))}
            </ul>
            <button onClick={fetchTotalStudentCount}> 
                Get Total Student Count
            </button>
            <p>Total students: {count}</p>

            <input
            placeholder="Enter Username"
            onChange={(e)=> setUsername(e.target.value)}/> 

            <input
            placeholder="Enter Password"
            onChange={(e)=> setPassword(e.target.value)}/>

            <button onClick={login}>Login</button>

        </div>
    );
}

export default App;