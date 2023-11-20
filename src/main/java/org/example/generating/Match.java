package org.example.generating;

import org.example.model.Equipment;
import org.example.model.PersonKind;
import org.example.model.Preference;
import org.example.service.Repository;
import org.example.service.Result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Match {
    private Repository repository;
    private List<Preference> lPref;
    private List<Equipment> lEquip;
    private List<Result> lRes = new ArrayList<>();
    private double totalScore = 0.0;
    public Match(Repository repository){
        this.repository = repository;
    }

    public void matching(){
        lPref = repository.getlPrefe();
        lEquip = repository.getlEquip();

        repository.mixLEquip();
        repository.mixLPrefe();

        shortMatch(PersonKind.C);
        shortMatch(PersonKind.J);
        shortMatch(PersonKind.A);
    }

    private void shortMatch(PersonKind kind){
        Preference pref;
        Equipment equip;
        Result result;

        for (Iterator<Preference> iterator = lPref.iterator(); iterator.hasNext();) {
            pref = iterator.next();
            pref.mixSkis();
            if (!lEquip.isEmpty())
                equip = lEquip.get(0);
            else
                break;

            if (pref.getP().getKind() == kind) {
                result = new Result(pref.getP().getId(), pref.getP().getKind(), equip.getSki(), getScore(pref, equip));
                totalScore += result.getScore();
                lRes.add(result);
                iterator.remove();

                if (equip.getQuantity() > 1) {
                    equip.setQuantity(equip.getQuantity() - 1);
                } else {
                    lEquip.remove(equip);
                }
            }
        }
    }

    public double getScore(Preference pref, Equipment equip){
        double score = 0.0;
        score += 0.012*Math.abs(pref.getSki().getLenght() - equip.getSki().getLenght());                          // lenght category
        score += pref.getSki().getType().equals(equip.getSki().getType()) ? 0.15 : 0.3;                                 // type category
        score *= (100 - pref.getP().getKind().getDiscountValue())/100.0;                                                // discount

        return score;
    }

    public double getTotalScore(){                                                                                      // total score
        totalScore += 0.1*getNotServedPeople();                                                                         // reward for serving all people
        return totalScore;
    }

    public int getNotServedPeople(){
        return lRes.size()-(lRes.size() - lPref.size());
    }

    public List<Result> getlRes() {
        return lRes;
    }
}
