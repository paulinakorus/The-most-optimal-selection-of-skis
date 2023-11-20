package org.example.generating;

import org.example.service.Repository;
import org.example.service.Result;
import org.example.service.TotalResult;

import java.util.ArrayList;
import java.util.List;

public class GenerateMatches {
    //private static final int NR_ITERATIONS = 100;
    private int iterations;
    private Repository repository;
    //private List<Double> lResults = new ArrayList<>();
    private List<TotalResult> totalResults = new ArrayList<>();
    private List<List<Result>> totalList = new ArrayList<>();

    public GenerateMatches(Repository repository){
        this.repository = repository;
    }

    public GenerateMatches(Repository repository, int iterations){
        this.repository = repository;
        this.iterations = iterations;
    }

    public void generating(){
        Match match;
        Repository work_repository;
        /*try {
            repository.eqiupReader(repository.getListFile().getName());
            repository.prefReader(repository.getPreferenceFile().getName());
        }
        catch(Exception e) {
            e.printStackTrace();
        }*/
        for(int i=0; i<iterations; i++){
            work_repository = new Repository(repository, repository.getlPrefe(), repository.getlEquip());
            match = new Match(work_repository);
            match.matching();

            totalResults.add(new TotalResult(match.getTotalScore(), match.getNotServedPeople()));
            totalList.add(match.getlRes());
        }
    }

    public int calBestOpt(){
        double min = totalResults.get(0).getResult();
        int best=0, i=0;

        for (TotalResult res : totalResults) {
            if (res.getResult()<min){
                min = res.getResult();
                best = i;
            }
            i++;
        }
        return best;
    }

    public TotalResult getBestResult(){
        return totalResults.get(calBestOpt());
    }

    public List<Result> getBestList(){
        return totalList.get(calBestOpt());
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}



        /*try {
                work_repository = repository;
                work_repository.eqiupReader();
                work_repository.prefReader();

                match = new Match(work_repository);
                match.matching();
                //lResults.add(match.getTotalScore());
                totalResults.add(new TotalResult(match.getTotalScore(), match.getNotServedPeople()));
                totalList.add(match.getlRes());
            } catch(Exception e)
            {
                System.out.println("File not found");
            }


            /*work_repository = repository;

            match = new Match(work_repository);
            match.matching();
            lResults.add(match.getTotalScore());
            totalList.add(match.getlRes());

            /*try{
                Repository work_repository = (Repository)((Repository)repository).clone();

                match = new Match(work_repository);
                match.matching();
                lResults.add(match.getTotalScore());
                totalList.add(match.getlRes());
            }catch (CloneNotSupportedException e){
                System.out.println("Cloning didn't work");
      }*/

    /*protected Object clone()throws CloneNotSupportedException{
        Repository work_repository = (Repository)((Repository)repository).clone();
        return work_repository;
    }*/
