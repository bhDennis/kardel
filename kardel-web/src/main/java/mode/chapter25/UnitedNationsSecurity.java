package mode.chapter25;

/**
 * Created by dennis on 2018/3/29.
 */
public class UnitedNationsSecurity extends UnitedNations{

    private USA usa;

    private Iraq iraq;

    public void setUsa(USA usa){
        this.usa = usa;
    }

    public void setIraq(Iraq iraq){
        this.iraq = iraq;
    }

    @Override
    public void declare(String message, Country country) {

        if(country instanceof Iraq){

            usa.getMessage(message);

            return;
        }

        if(country instanceof USA){

            iraq.getMessage(message);

            return;
        }
    }
}
