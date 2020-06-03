import axios from 'axios'

export const proxy={
    methods :{
        myAlert(d){
          alert(d)
        },
        paging(d) {
            const movies = []
            const pages = []
            let temp = {}

            axios
                .get(d)
                .then(({data})=>{
                    data.list.forEach(elem => {movies.push(elem)})
                    let pager = data.pager
                    alert('>>'+pager.rowCount)
                    let i = pager.pageStart +1
                    console.log(`페이지 끝: ${pager.pageEnd}`)
                    for(; i <= pager.pageEnd + 1;i++){
                        pages.push(i)
                    }
                    temp.rowCount = pager.rowCount
                    temp.existPrev = pager.existPrev
                    temp.existNext = pager.existNext
                })
                .catch(err=>{
                    alert(`영화 통신 실패 ${err}`)
                })
            return {movies, pages, temp}
        }
    }
}