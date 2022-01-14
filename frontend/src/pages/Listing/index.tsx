import axios from "axios";
import MovieCard from "components/MovieCards";
import Pagination from "components/Pagination";
import { useState, useEffect } from "react";
import { MoviePage } from "types/movie";


function Listing() {

  const [pageNumber, setPageNumber] = useState(0);
  const [page, setPage] = useState<MoviePage>({
    content: [],
    last: true,
    totalPages: 0,
    totalElements: 0,
    size: 12,
    number: 0,
    first: true,
    numberOfElements: 0,
    empty: true,
  });

  useEffect(() => {
    axios.get(`http://localhost:8080/movies?size=128page=${pageNumber}`)
      .then(response => {
        const data = response.data as MoviePage;
        setPage(data);
      })
  }, [pageNumber]);

  return (
    <>
      <Pagination />
      <div className="container">
        <div className="row">
          {page.content.map(movie => (
            < div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3" >
              <MovieCard movie={movie} />
            </div>
          )
          )};
        </div>
      </div>

    </>

  );
}

export default Listing;